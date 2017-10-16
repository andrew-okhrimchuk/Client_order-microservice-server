package com.repository;


import com.Entity.Client;

import com.ClientServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.math.BigInteger;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ClientServer.class)
public class ClientRepositoryTest {
    @Autowired
    private ClientRepository repository;

    @Test
    public void shouldFindClientByid1() {

        Client stub = getStubClient();
        repository.save(stub);
        Client found = repository.findByid1(stub.getId1());
        repository.delete(stub);

        assertEquals(stub.getName(), found.getName());
        assertEquals(stub.getSex(), found.getSex());
        assertEquals(stub.getSurname(), found.getSurname());
        assertEquals(stub.getId1(), found.getId1());
        assertNotEquals(stub, found);
        System.out.println(stub);
        System.out.println(found);


    }

    private Client getStubClient() {

        Client client = new Client();
        client.setName("Zaza");
        client.setSex("f");
        client.setSurname("Qwerty");
        client.setDateOfBirth(new Date());


        return client;
    }
}
