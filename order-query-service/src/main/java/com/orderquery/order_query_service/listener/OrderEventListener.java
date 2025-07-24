package com.orderquery.order_query_service.listener;

import com.orderquery.order_query_service.model.OrderView;
import com.orderquery.order_query_service.repository.OrderViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderEventListener {

    @Autowired
    private OrderViewRepository repository;

    @KafkaListener(topics = "order.events", groupId = "order-query-group")
    public void consume(OrderView order) {
        repository.save(order);
    }
}
