package com.repository;
import com.Entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.math.BigInteger;
import java.util.List;

@RepositoryRestResource
public interface ClientRepository extends CrudRepository<Client, BigInteger> {

    Client findByid1(BigInteger id1);
    List<Client> findAll();
}
