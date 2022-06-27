package com.webApp.repository;

import com.webApp.model.AuthenRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRipo extends MongoRepository<AuthenRequest, String> {
}
