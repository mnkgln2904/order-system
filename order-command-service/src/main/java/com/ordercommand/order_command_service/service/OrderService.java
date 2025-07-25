package com.ordercommand.order_command_service.service;

import com.ordercommand.order_command_service.model.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(Order order);

    List<Order> getAllOrders();

    Order getOrderById(Long id);

    Order updateOrder(Long id, Order order);

    void deleteOrder(Long id);

    List<Order> getOrdersByStatus(String status);

    List<Order> getOrdersByCustomerName(String customerName);

    List<Order> getOrdersByAmountGreaterThan(Double amount);

    List<Order> createBulkOrders(List<Order> orders);

    Order updateOrderStatus(Long id, String status);
}
