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
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ClientServer.class)
public class OrderRepositoryTest {
    @Autowired
    private OrderRepository repository;
    @Autowired
    private ClientRepository repository2;

    @Test
    public void shouldFindOrderByid1() {

        Client stubClient = new Client();
        BigInteger id = stubClient.getId1();
        stubClient.setSurname("Gurieva");
        stubClient.setName("Zaza");
        stubClient.setSex("f");
        repository2.save(stubClient);

        Order stubOrder = getStubOrder(stubClient);

        repository.save(stubOrder);

        Order found = repository.findByid(stubOrder.getId());
        repository.delete(stubOrder);

        assertEquals(stubOrder.getId(), found.getId());
        assertEquals(stubOrder.getClient().getId1(), found.getClient().getId1());
        assertEquals(stubOrder.isStatus(), found.isStatus());
        assertEquals(stubOrder.getCurrency(), found.getCurrency());
        assertNotEquals(stubOrder, found);
        System.out.println(stubOrder);
        System.out.println(found);
        repository2.delete(stubClient);

    }

    private Order getStubOrder(Client stubClient) {

        Order order = new Order();
        order.setClient(stubClient);
        order.setStatus(true);
        order.setAmount(33.0);
        order.setDate(new Date());
        order.setCurrency("aza");

        return order;
    }
}
