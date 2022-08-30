package com.worker.compras.service;

import com.worker.compras.model.entity.Order;
//import com.worker.compras.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    //@Autowired
    //private OrderRepository orderRepository;

    public Order saveOrder(Order order) {
        return new Order();
        //return this.orderRepository.save(order);
    }
}
