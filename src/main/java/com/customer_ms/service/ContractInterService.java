package com.customer_ms.service;

import com.customer_ms.config.WebClientConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class ContractInterService {
    private WebClient webClient;

    public ContractInterService(WebClient.Builder builder){
        this.webClient = builder.baseUrl("http://localhost:8089/contract-service").build();
    }

    //fire and forget method to cancel contracts
    public void cancelContractForCustomer(int id){
        Map<String, String> body = Map.of("status", "Cancelled"); //since patch needs a json body
        webClient.patch()
                .uri("/customers/"+id+"/contracts/status")
                .bodyValue(body)
                .retrieve()
                .toBodilessEntity()
                .subscribe(); //actual request wouldnt be sent without this
    }
}
