package com.repository;


import com.ClientServer;
import com.Entity.Client;
import com.Entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigInteger;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ClientServer.class)
public class OrderRepositoryMicroTest {
    @Autowired
    private OrderRepository repository;


    @Test
    public void shouldFindOrderByid1() {

        List<Order> found = repository.findAll();
        System.out.println("repository.findAll = " + found.size());
        assertNotNull(found);


    }


}
