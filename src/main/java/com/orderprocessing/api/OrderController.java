package com.orderprocessing.api;

import com.orderprocessing.models.Order;
import com.orderprocessing.services.BulkOrderService;
import com.orderprocessing.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private static final String NO_BODY = "Body not found";
    @Autowired
    OrderService orderService;

    @Autowired
    BulkOrderService bulkOrderService;

    @GetMapping("{id}")
    public Order getOrder(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("")
    public String createOrder(@RequestBody Order order) {
        if(order != null) {
            orderService.createOrder(order);
            return "order created";
        }
        else {
            return NO_BODY;
        }
    }

    @PostMapping("bulk")
    public String createMultipleOrders(@RequestBody List<Order> orders) {
        if(orders != null && !orders.isEmpty()) {
            bulkOrderService.createMultipleOrders(orders);
            return String.format("Created orders.", orders.size());
        }
        else {
            return NO_BODY;
        }
    }

    @DeleteMapping("{id}")
    public String deleteOrder(@PathVariable("id") int id) {
        if(id > 0) {
            if(orderService.deleteOrder(id)) {
                return "order deleted";
            }
            else {
                return "order can't be deleted";
            }
        }
        return "Invalid id";
    }

    @PutMapping("bulk")
    public String updateMultipleOrders(@RequestBody List<Order> orders) {
        if(orders != null) {
            bulkOrderService.updateMultipleOrders(orders);
            return "Orders updated";
        }
        else {
            return NO_BODY;
        }
    }
}
