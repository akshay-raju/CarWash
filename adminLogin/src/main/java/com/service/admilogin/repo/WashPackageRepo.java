package com.service.admilogin.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.service.admilogin.model.WashPackage;
@Repository
public interface WashPackageRepo extends MongoRepository<WashPackage, String>{

}
