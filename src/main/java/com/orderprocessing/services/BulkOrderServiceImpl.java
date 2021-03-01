package com.orderprocessing.services;

import com.orderprocessing.models.Order;
import com.orderprocessing.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BulkOrderServiceImpl implements BulkOrderService{

    @Autowired
    private OrderRepository repository;

    @Override
    public List<Order> createMultipleOrders(List<Order> orders) {
        return (List<Order>)repository.saveAll(orders) ;
    }

    @Override
    public boolean updateMultipleOrders(List<Order> orders) {
        try {
            repository.saveAll(orders);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
