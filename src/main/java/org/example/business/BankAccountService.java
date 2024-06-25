package org.example.business;

import org.example.exceptions.AccountNotFoundException;
import org.example.exceptions.BalanceNotSufficentException;
import org.example.model.BankAccount;

import java.util.List;

public interface BankAccountService {
    BankAccount addBankAccount(BankAccount account);
    List<BankAccount> getAllBankAccounts();
    BankAccount getAccountById(String id) throws AccountNotFoundException;

    void addRandomData(int size);

    void credit(String accountId, double amount) throws AccountNotFoundException;
    void debit(String accountId, double amount) throws AccountNotFoundException, BalanceNotSufficentException;
    void transfer(String accountSource, String accountDestination, double amount) throws BalanceNotSufficentException, AccountNotFoundException;
}
