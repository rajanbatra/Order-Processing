package com.orderprocessing.services;

import com.orderprocessing.models.Order;
import com.orderprocessing.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository repository;

    @Override
    public Order getOrderById(int id) {
        Optional<Order> answer = repository.findById(id);
        if(answer.isPresent()) {
            return answer.get();
        }
        else {
            return null;
        }
    }

    @Override
    public Order createOrder(Order order) {
        return repository.save(order);
    }

    @Override
    public boolean deleteOrder(int id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
