package org.example.business;

import org.example.exceptions.AccountNotFoundException;
import org.example.exceptions.BalanceNotSufficentException;
import org.example.model.AccountStatus;
import org.example.model.BankAccount;
import org.example.model.CurrentAccount;
import org.example.model.SavingAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankAccountServiceImp implements BankAccountService{
    private List<BankAccount> bankAccountList = new ArrayList<>();
    @Override
    public BankAccount addBankAccount(BankAccount account) {
        bankAccountList.add(account);
        return account;
    }

    @Override
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountList;
    }

    @Override
    public BankAccount getAccountById(String id) throws AccountNotFoundException {
        return bankAccountList
                .stream()
                .filter(account -> account.getAccountId().equals(id))
                .findFirst()
                .orElseThrow( ()-> new AccountNotFoundException("Account not found") );

        //imperative approach
        /*for(BankAccount bankAccount:bankAccountList){
            if(bankAccount.getAccountId().equals(id)){
                return bankAccount;
            }
        }
        throw new AccountNotFoundException("Account not found");*/
    }

    @Override
    public void addRandomData(int size) {
        AccountStatus[] values = AccountStatus.values();
        Random random = new Random();
        for(int i= 0; i< size; i++){
            BankAccount bankAccount;
            if(Math.random()>0.5){
                bankAccount = new CurrentAccount(Math.random()* 10000, Math.random() > 0.5 ? "USD" : "MAD" , Math.random() * 5000 );
                bankAccount.setStatus(values[random.nextInt(values.length)]);
            } else {
                bankAccount = new SavingAccount(Math.random() * 10000, Math.random() > 0.5 ? "USD" : "MAD", 3 + Math.random() * 7);
                bankAccount.setStatus(values[random.nextInt(values.length)]);
            }
            bankAccountList.add(bankAccount);
        }
    }

    @Override
    public void credit(String accountId, double amount) throws AccountNotFoundException {
        BankAccount accountById = getAccountById(accountId);
        accountById.setBalance(accountById.getBalance()+amount);
    }

    @Override
    public void debit(String accountId, double amount) throws AccountNotFoundException,BalanceNotSufficentException {
        BankAccount accountById = getAccountById(accountId);
        if(amount > accountById.getBalance() ) throw new BalanceNotSufficentException("balance not sufficent!!");
        accountById.setBalance(accountById.getBalance()-amount);

    }

    @Override
    public void transfer(String accountSource, String accountDestination, double amount) throws BalanceNotSufficentException, AccountNotFoundException {
        debit(accountSource,amount);
        credit(accountDestination, amount);

    }
}
