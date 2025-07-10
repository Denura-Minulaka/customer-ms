package com.customer_ms.service.interservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class ContractService {
    private WebClient webClient;

    public ContractService(WebClient.Builder builder, @Value("${service.contract.url}") String url){
        this.webClient = builder.baseUrl(url).build();
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
