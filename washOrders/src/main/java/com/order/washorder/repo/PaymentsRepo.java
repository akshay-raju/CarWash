package com.order.washorder.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.order.washorder.model.Payment;

public interface PaymentsRepo extends MongoRepository<Payment, String>{

}
