package com.payment.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.payment.model.Payment;

public interface PaymentRepo extends MongoRepository<Payment, String>{

}
