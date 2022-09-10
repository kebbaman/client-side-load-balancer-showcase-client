package com.kebba.clientsideloadbalancershowcase.loadbalancer;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@LoadBalancerClient(name = "cashier-service", configuration = CashierServiceInstanceConfiguration.class)
//This creates a load balanced webclient to perform remote requests
public class WebClientConfig {
    @LoadBalanced
    @Bean
    WebClient.Builder webClientBuilder() {  //This is a replacement of the RestTemplate
        return WebClient.builder();
    }
}

