package com.services;

import com.Entity.Order;
import com.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository repository;
    @Override
    public List<Order> findAll() {
        List<Order> result = new ArrayList<>();
            for (Order order : repository.findAll()) {
                result.add(order);
            }
        return result;
    }
    @Override
    public Order findById(BigInteger accountId){
        return repository.findByid(accountId);
    }
    @Override
    public Order create(Order order){
        Assert.notNull(repository.findByid(order.getId()), "can't create order with id = " + order.getId());
        repository.save(order);
        return order;
    }
    @Override
    public Order saveChanges(Order update){
        Order order = repository.findByid(update.getId());
        Assert.notNull(order, "can't find order with id = " + update.getId());
        repository.save(order);
        return order;
    }
    @Override
    public List<Order> findAllByTIN2(BigInteger tIN2){
        List<Order> result = new ArrayList<>();
       // result = repository.findByTIN2ReturnList(tIN2) ;

        // костыль конечно и не рациональное исп-е памяти....:
        for (Order order : repository.findAll()) {
            if (order.getClient().getId1().equals(tIN2)){
            result.add(order);}
        }
        return result;
    }

    @Override
    public Order saveChangesStatus(BigInteger id, boolean status){
        Order order = repository.findByid(id);
        Assert.notNull(order, "can't find order with id = " + id);
        order.setStatus(status);
        repository.save(order);
        return order;
    }
}
