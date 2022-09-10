package com.kebba.clientsideloadbalancershowcase.loadbalancer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CashierServiceInstanceListSupplier implements ServiceInstanceListSupplier {
    @Autowired
    LoadBalancerConfig loadBalancerConfig;


    @Override
    public String getServiceId() {
        return loadBalancerConfig.getServiceId();
    }

    @Override
    public Flux<List<ServiceInstance>> get() {
        List<Map<String,String>> servers = loadBalancerConfig.getServers();
        List<ServiceInstance> serviceInstances = new ArrayList<>();
        for (Map<String, String> server : servers) {
            serviceInstances.add(new DefaultServiceInstance(loadBalancerConfig.getServiceId()+server.get("instanceId"),
                    loadBalancerConfig.getServiceId(),
                    server.get("host"),
                    Integer.valueOf(server.get("port")),Boolean.getBoolean(server.get("secure"))));
        }
        return Flux.just(serviceInstances);
    }
}
