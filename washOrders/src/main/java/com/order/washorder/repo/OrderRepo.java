package com.order.washorder.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.order.washorder.model.WashOrder;
@Repository
public interface OrderRepo extends MongoRepository<WashOrder, String>{

}
