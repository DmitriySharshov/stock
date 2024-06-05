package com.example.stock.controllers;

import com.example.stock.entity.RequestDto;
import com.example.stock.entity.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("application2")
@AllArgsConstructor
public class SimpleController {

    private final RestTemplate restTemplate;

   @GetMapping()
    public Response getResponse(){
       ResponseEntity<Response> response = restTemplate
               .getForEntity("http://localhost:8081/request",Response.class);
        return response.getBody();
   }

    @PostMapping()
    public String getName(@RequestBody RequestDto requestDto){
        HttpEntity<RequestDto> requestDtoHttpEntity = new HttpEntity<>(requestDto);
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://localhost:8081/request", requestDtoHttpEntity, String.class);
        return stringResponseEntity.getBody();
    }
}
