package com.orderprocessing.services;

import com.orderprocessing.models.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    Order getOrderById(int id);
    Order createOrder(Order order);
    boolean deleteOrder(int id);
}
