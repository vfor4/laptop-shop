package com.laptopshop.service;

import com.laptopshop.models.OrderRequest;
import com.laptopshop.models.OrderResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import reactor.core.publisher.Mono;

@Service
public class OrderService {
    
    private final WebClient webClient;
    
    public OrderService(WebClient.Builder builder){
        webClient = builder.baseUrl("https://dev-online-gateway.ghn.vn/shiip/public-api/v2/").build();
    }

    public OrderResponse createOrder(OrderRequest orderRequest){
        OrderResponse orderResponse = webClient
        .post()
        .uri("shipping-order/create")
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .header("ShopId", "86128")
        .header("Token", "3bc6b4b9-9b9b-11ec-ac64-422c37c6de1b")
        .body(Mono.justOrEmpty(orderRequest), OrderRequest.class)
        .retrieve().onStatus(HttpStatus::isError, response -> response.bodyToMono(String.class) // error body as String or other class
        .flatMap(error -> Mono.error(new RuntimeException(error))))
        .bodyToMono(OrderResponse.class).block();
       
        return orderResponse;
    }

    public boolean test(){
        return false;
    }

}
