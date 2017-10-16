package com.services;

import com.Entity.Client;

import java.math.BigInteger;
import java.util.List;

public interface ClientService {

    List<Client> findAll();
    Client findById(BigInteger client_id);
    Client create(Client client);
    Client saveChanges(BigInteger client_id, Client update);
}
