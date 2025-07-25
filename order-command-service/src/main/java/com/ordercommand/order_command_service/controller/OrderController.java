package com.ordercommand.order_command_service.controller;

import com.ordercommand.order_command_service.model.Order;
import com.ordercommand.order_command_service.service.OrderService;
import com.ordercommand.order_command_service.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        return ResponseEntity.ok(orderService.updateOrder(id, order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ New: Get by Status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Order>> getOrdersByStatus(@PathVariable String status) {
        return ResponseEntity.ok(orderService.getOrdersByStatus(status));
    }

    // ✅ New: Get by Customer Name
    @GetMapping("/customer/{name}")
    public ResponseEntity<List<Order>> getOrdersByCustomer(@PathVariable String name) {
        return ResponseEntity.ok(orderService.getOrdersByCustomerName(name));
    }

    // ✅ New: Get by Amount Greater Than
    @GetMapping("/amount/greater-than/{amount}")
    public ResponseEntity<List<Order>> getOrdersGreaterThan(@PathVariable Double amount) {
        return ResponseEntity.ok(orderService.getOrdersByAmountGreaterThan(amount));
    }

    // ✅ New: Bulk Create
    @PostMapping("/bulk")
    public ResponseEntity<List<Order>> createBulkOrders(@RequestBody List<Order> orders) {
        return ResponseEntity.ok(orderService.createBulkOrders(orders));
    }

    // ✅ New: Update Only Status
    @PatchMapping("/{id}/status")
    public ResponseEntity<Order> updateStatus(@PathVariable Long id, @RequestBody Map<String, String> update) {
        return ResponseEntity.ok(orderService.updateOrderStatus(id, update.get("status")));
    }
}
