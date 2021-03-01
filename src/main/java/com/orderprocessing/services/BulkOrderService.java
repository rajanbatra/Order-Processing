package com.orderprocessing.services;

import com.orderprocessing.models.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BulkOrderService {
    List<Order> createMultipleOrders(List<Order> orders);
    boolean updateMultipleOrders(List<Order> orders);
}
