package io.toanyone.client.controller;

import io.toanyone.client.domain.Client;
import io.toanyone.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/client/{clientId}")
    @ResponseBody
    public HttpEntity<Client> query(@PathVariable String clientId) {
        return service.queryByClientId(clientId)
                .map(ResponseEntity::ok)
                .orElseThrow(()-> new RuntimeException("Not found client : " + clientId));
    }
}
