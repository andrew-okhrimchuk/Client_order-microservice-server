package com.services;

import com.Entity.Order;

import java.math.BigInteger;
import java.util.List;

public interface OrderService {

    List<Order> findAll();
    Order findById(BigInteger order_id);
    Order create(Order order);
    Order saveChanges(Order update);
    List<Order> findAllByTIN2(BigInteger client_id);
    Order saveChangesStatus(BigInteger order_id, boolean status);
}
