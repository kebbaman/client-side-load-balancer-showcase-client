package com.kebba.clientsideloadbalancershowcase.loadbalancer;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import java.util.List;
import java.util.Map;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "load-balancer-config")
public class LoadBalancerConfig {

    @Getter
    @Setter
    private List<Map<String,String>> servers;

    @Getter
    @Setter
    private String serviceId;



}
