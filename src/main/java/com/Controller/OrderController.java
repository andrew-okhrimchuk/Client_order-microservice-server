package com.Controller;

import com.Entity.Client;
import com.Entity.Order;
import com.services.ClientService;
import com.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class OrderController {
    protected Logger logger = Logger
            .getLogger(OrderController.class.getName());

    @Autowired
    OrderService ordertService;
    @Autowired
    ClientService clientService;

    @RequestMapping("/order")
    public Order[] all() {
        logger.info("order-microservice all() invoked");
        List<Order> order = ordertService.findAll();
        logger.info("order-microservice all() found: " + order.size());
        return order.toArray(new Order[order.size()]);
    }

    @RequestMapping("/order/{id}")
    public Order byId(@PathVariable("id") String id) {
        logger.info("order-microservice byId() invoked: " + id);
        Order order = ordertService.findById(new BigInteger(id));
        logger.info("order-microservice byId() found: " + order);
        return order;
    }

    @RequestMapping("/order/save/{order}")
    public Order saveOrder( @PathVariable("order") Order order) {
        logger.info("order-microservice byOrderSaveId invoked: " + order.getId());
        Order saveOrder = ordertService.saveChanges(order);
        logger.info("order-microservice byOrderId saveOrder: " + order.getId());
        return saveOrder;
    }

    @RequestMapping("/order/create/{order}")
    public Order createOrder( @PathVariable("order") Order order) {
        Order createOrder = ordertService.create(order);
        logger.info("order-microservice byOrder create: " + order);
        return createOrder;
    }

    @RequestMapping("/order/create/{clientId},{status},{amount},{date},{currency} ")
    public Order create(@PathVariable("tIN2") BigInteger clientId, @PathVariable("status")boolean status, @PathVariable("amount") double amount, @PathVariable("date") Date date, @PathVariable("currency") String currency) {
        Order createOrder = new Order();
        createOrder.setClient(clientService.findById(clientId));
        createOrder.setStatus(status);
        createOrder.setAmount(amount);
        createOrder.setDate(date);
        createOrder.setCurrency(currency);
        ordertService.create(createOrder);
        logger.info("order-microservice byOrder createId = : " + createOrder.getId());
        return createOrder;
    }

    @RequestMapping("/order/findByTIN/{id}")
    public List<Order> findByTIN( @PathVariable("id") BigInteger id) {
        List<Order> lisfOrderByTIN = ordertService.findAllByTIN2(id);
        logger.info("order-microservice byOrder findByTIN2.size(): " + lisfOrderByTIN.size());
        return lisfOrderByTIN;
    }

    @RequestMapping("/order/saveChangesStatus/{id},{status}")
    public Order saveChangesStatus( @PathVariable("id") BigInteger id, @PathVariable("status") boolean status) {
        Order order = ordertService.saveChangesStatus(id, status);
        logger.info("order-microservice byOrder saveChangesStatus: " + id +" is "+ status);
        return order;
    }
}
