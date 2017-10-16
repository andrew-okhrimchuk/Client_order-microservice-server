package com.services;

import com.Entity.Client;
import com.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository repository;
    @Override
    public List<Client> findAll() {
        List<Client> result = new ArrayList<>();
            for (Client client : repository.findAll()) {
                result.add(client);
            }
        return result;
    }
    @Override
    public Client findById(BigInteger accountId){
        return repository.findByid1(accountId);
    }
    @Override
    public Client create(Client client){
        Client clie = repository.findByid1(client.getId1());
        Assert.notNull(clie, "can't create account with id = " + client.getId1());
        repository.save(client);
        return client;
    }
    @Override
    public Client saveChanges(BigInteger tIN, Client update){
        Client client = repository.findByid1(tIN);
        Assert.notNull(client, "can't find account with TIN = " + tIN);
        repository.save(client);
       //statisticsClient.updateStatistics(name, client);
        return client;
    }
}
