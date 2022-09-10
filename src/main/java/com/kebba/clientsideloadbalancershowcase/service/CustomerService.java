package com.kebba.clientsideloadbalancershowcase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CustomerService {
    @Autowired
    private WebClient.Builder webClientBuilder;

    public String getServed(){
        WebClient loadBalancedWebClient = webClientBuilder.build();  //load balanced webClient (as default using a round-robin policy)

        String response = loadBalancedWebClient.get().uri("http://cashier-service/cashier/get-served")
                .retrieve().toEntity(String.class)
                .block().getBody();
        return response;
    }
}
