package com.bank.bank;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping
    public Account create(@RequestParam String name) {
        return service.createAccount(name);
    }

    @GetMapping("/{id}")
    public Account get(@PathVariable String id) {
        return service.getAccount(id);
    }

    @PostMapping("/{id}/deposit")
    public Account deposit(@PathVariable String id, @RequestParam double amount) {
        return service.deposit(id, amount);
    }

    @PostMapping("/{id}/withdraw")
    public Account withdraw(@PathVariable String id, @RequestParam double amount) {
        return service.withdraw(id, amount);
    }
}