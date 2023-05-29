package com.nttdata.account.services;

import com.nttdata.account.models.dao.AccountDao;
import com.nttdata.account.models.documents.Account;
import com.nttdata.account.models.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountServicieImpl implements AccountService {

    @Autowired
    private AccountDao dao;

    @Override
    public Flux<Account> findAll() {
        return dao.findAll();
    }

    @Override
    public Mono<Account> findById(String id) {
        return dao.findById(id);
    }

    @Override
    public Mono<Account> findByCustomerId(String customerId) {
        return dao.findByCustomerId(customerId);
    }

    @Override
    public Mono<Account> save(Account account) {
        return dao.save(account);
    }

    @Override
    public Mono<Void> delete(Account account) {
        return dao.delete(account);
    }
}
