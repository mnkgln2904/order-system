package com.ordercommand.order_command_service.service;

import com.ordercommand.order_command_service.model.Order;
import com.ordercommand.order_command_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    private static final String TOPIC = "order.events";

    public void createOrder(Order order) {
        repository.save(order);
        kafkaTemplate.send(TOPIC, order);
    }
}
