package com.insurfin.repository;

import com.insurfin.model.Distributor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributorRepository extends MongoRepository<Distributor, String> {

    Distributor findByUserId(String userId);
}
