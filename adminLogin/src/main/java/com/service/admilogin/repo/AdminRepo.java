package com.service.admilogin.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.service.admilogin.model.Admin;
@Repository
public interface AdminRepo extends MongoRepository<Admin,String>{

}
