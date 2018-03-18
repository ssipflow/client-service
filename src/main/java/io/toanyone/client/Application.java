package io.toanyone.client;

import io.toanyone.client.domain.Client;
import io.toanyone.client.repository.ClientRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCircuitBreaker
@EnableEurekaClient
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(ClientRepository repository) {
		Client client = new Client();

		client.setSeq(1);
		client.setClientId("msa");
		client.setClientSecret("12345678");
		client.setAuthorizedGrantTypes("client_credentials,password,refresh_token");
		client.setScope("read,write");
		client.setAutoApproveScopes("read,write");
		client.setAccessTokenValiditySeconds(1000 * 60 * 5);
		client.setRefreshTokenValiditySeconds(1000 * 60 * 5);
		client.setAuthorities("ROLE_MOBILE_CLIENT");
		client.setResourceIds("API");

		return (args) -> {
			repository.save(client);
		};
	}
}
