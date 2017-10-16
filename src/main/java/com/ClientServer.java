package com;

import com.Config.Configurations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.logging.Logger;


@SpringBootApplication
@EnableDiscoveryClient
@ImportAutoConfiguration(value = {Configurations.class})
public class ClientServer {

	//@Autowired
	//protected ClientRepository clientRepository;

	protected Logger logger = Logger.getLogger(ClientServer.class.getName());

	public static void main(String[] args) {
			SpringApplication.run(ClientServer.class, args);
	}
}
