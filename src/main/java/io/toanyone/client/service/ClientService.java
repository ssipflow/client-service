package io.toanyone.client.service;

import io.toanyone.client.domain.Client;
import io.toanyone.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

//    @HystrixCommand(commandKey = "클라이언트조회",  fallbackMethod = "queryByIdDefault",
//            threadPoolKey = "Query Client", threadPoolProperties = {
//            @HystrixProperty(name="coreSize", value="30"),
//            @HystrixProperty(name="maxQueueSize", value="30")
//    })
    public Optional<Client> queryByClientId(String clientId) {
        return repository.findByClientId(clientId);
    }


    public Optional<Client> queryByClientIdFallBack(String clientId) {
        return Optional.empty();
    }

}
