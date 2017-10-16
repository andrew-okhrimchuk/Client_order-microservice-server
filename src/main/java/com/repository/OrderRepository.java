package com.repository;
import com.Entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.math.BigInteger;
import java.util.List;

@RepositoryRestResource
public interface OrderRepository extends CrudRepository<Order, BigInteger> {

    Order findByid(BigInteger id);
  //  @Query("select c from Order c where c.tIN2 = :tIN2")
   // List<Order> findByTIN2ReturnList(BigInteger tIN2);
      List<Order> findAll();

}
