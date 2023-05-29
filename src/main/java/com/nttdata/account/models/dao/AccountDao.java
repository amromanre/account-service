package com.nttdata.account.models.dao;

import com.nttdata.account.models.documents.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface AccountDao extends ReactiveMongoRepository<Account, String> {
    public Mono<Account> findByCustomerId(String customerId);
}
