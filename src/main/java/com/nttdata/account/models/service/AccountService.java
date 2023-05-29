package com.nttdata.account.models.service;

import com.nttdata.account.models.documents.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {

    public Flux<Account> findAll();

    public Mono<Account> findById(String id);

    public Mono<Account> findByCustomerId(String customerId);

    public Mono<Account> save(Account account);

    public Mono<Void> delete(Account account);
}
