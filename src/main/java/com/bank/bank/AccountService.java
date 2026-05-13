package com.bank.bank;

import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class AccountService {

    private final AccountRepository repo;

    public AccountService(AccountRepository repo) {
        this.repo = repo;
    }

    public Account createAccount(String name) {
        Account acc = new Account();
        acc.setId(UUID.randomUUID().toString());
        acc.setName(name);
        acc.setBalance(0);
        return repo.save(acc);
    }

    public Account getAccount(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public Account deposit(String id, double amount) {
        Account acc = getAccount(id);
        acc.setBalance(acc.getBalance() + amount);
        return repo.save(acc);
    }

    public Account withdraw(String id, double amount) {
        Account acc = getAccount(id);

        if (acc.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }

        acc.setBalance(acc.getBalance() - amount);
        return repo.save(acc);
    }
}