package com.Controller;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Logger;

import com.Entity.Client;
import com.repository.ClientRepository;
import com.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    protected Logger logger = Logger
            .getLogger(ClientController.class.getName());

    @Autowired
    ClientService clientService;
    @Autowired
    ClientRepository clientRepository;

    @RequestMapping(value = "/client", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Client[] all() {
        logger.info("client-microservice all() invoked");
     //   List<Client> client = clientService.findAll();
        List<Client> client = clientRepository.findAll();
        logger.info("client-microservice all() found: " + client.size());
        return client.toArray(new Client[client.size()]);
    }

    @RequestMapping(value ="/client/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Client byId(@PathVariable("id") String id) {
        logger.info("client-microservice byId() invoked: " + id);
        Client client = clientService.findById(new BigInteger(id));
        logger.info("client-microservice byId() found: " + client.getName());
        return client;
    }

    @RequestMapping(value ="/client/save/{client}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Client saveClient( @PathVariable("client") Client client) {
        logger.info("client-microservice byClientSaveId invoked: " + client.getName());
        Client saveClient = clientService.saveChanges(client.getId1(), client );
        logger.info("client-microservice byClientSaveId found: " + client.getName());
        return saveClient;
    }

    @RequestMapping(value ="/client/create/{client}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Client createClient( @PathVariable("client") Client client) {
        Client createClient = clientService.create(client );
        logger.info("client-microservice byClient found: " + client);
        return createClient;
    }
}
