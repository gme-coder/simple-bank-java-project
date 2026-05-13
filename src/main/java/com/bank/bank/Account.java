package com.bank.bank;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {

    @Id
    private String id;
    private String name;
    private double balance;

    public Account() {}

    public Account(String id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getBalance() { return balance; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setBalance(double balance) { this.balance = balance; }
}