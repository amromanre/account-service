package com.nttdata.account.controllers;

import com.nttdata.account.models.documents.Account;
import com.nttdata.account.models.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Date;
/**
 * Account Class, which manages bank account information.
 */
@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    /**
     * Method that returns the list of accounts
     * @return Mono<ResponseEntity<Flux<Account>>>
     */
    @GetMapping()
    public Mono<ResponseEntity<Flux<Account>>> toList(){
        return Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll()));
    }

    /**
     * Method that looks for an account by id.
     * @param id
     * @return Mono<ResponseEntity<Account>>
     */
    @GetMapping("/{id}")
    public Mono<ResponseEntity<Account>> findAccount(@PathVariable String id){
        return service.findById(id).map(c -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(c))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    /**
     * Method that looks for an account by customer Id.
     * @param customerId
     * @return Mono<ResponseEntity<Account>>
     */
    @GetMapping("/customer/{customerId}")
    public Mono<ResponseEntity<Account>> lookForClient(@PathVariable String customerId){
        return service.findByCustomerId(customerId).map(c -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(c))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    /**
     *	Method, to create a new account.
     * @param account
     * @return Mono<ResponseEntity<Account>>
     */
    @PostMapping
    public Mono<ResponseEntity<Account>> newAccount(@RequestBody Account account){
        if(account.getCreateAt() == null){
            account.setCreateAt(new Date());
        }
        return service.save(account)
                .map(c -> ResponseEntity.created(URI.create("/api/accounts".concat(c.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(c)
                );
    }

}
