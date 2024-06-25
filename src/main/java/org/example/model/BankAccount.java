package org.example.model;

import java.util.UUID;

public abstract class BankAccount {
     private String accountId;
     private double balance;
     private  String currency;
     private AccountStatus status;

    public BankAccount(){
        this.accountId = UUID.randomUUID().toString();
        this.status = AccountStatus.CREATED;
    }
    public  BankAccount(String currency, double balance){
        this();
        this.currency = currency;
        this.balance = balance;
    }

    public BankAccount(double b, String c){
        this();
        this.balance = b;
        this.currency = c;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        status = status;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountId='" + accountId + '\'' +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", status=" + status +
                '}';
    }

    public abstract String getType();
}
