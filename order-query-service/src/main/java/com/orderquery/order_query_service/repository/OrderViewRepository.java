package com.orderquery.order_query_service.repository;

import com.orderquery.order_query_service.model.OrderView;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderViewRepository extends CouchbaseRepository<OrderView, String> {}
