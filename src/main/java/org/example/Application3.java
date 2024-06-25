package org.example;

import org.example.business.BankAccountService;
import org.example.business.BankAccountServiceImp;
import org.example.exceptions.AccountNotFoundException;
import org.example.exceptions.BalanceNotSufficentException;
import org.example.model.BankAccount;
import org.example.model.CurrentAccount;
import org.example.utils.DataTransformationUtils;

public class Application3 {
    public static void main(String[] args) {
        BankAccountService bankAccountService = new BankAccountServiceImp();
        bankAccountService.addRandomData(30);

        BankAccount bankAccount1 = new CurrentAccount(32333, "MAD",5500);
        bankAccount1.setAccountId("CC1");
        bankAccountService.addBankAccount(bankAccount1);

        BankAccount bankAccount2 = new CurrentAccount(16333, "MAD",100000);
        bankAccount2.setAccountId("CC2");
        bankAccountService.addBankAccount(bankAccount2);


        //bankAccountService.getAllBankAccounts().forEach(System.out::println);
        bankAccountService.getAllBankAccounts().forEach(account -> System.out.println(DataTransformationUtils.toJson(account)));
        bankAccountService.getAllBankAccounts()
                .stream()
                .map(DataTransformationUtils::toJson)
                .forEach(System.out::println);

        try {
            System.out.println("=======Bank Accounts=============================");
            BankAccount acc1 = bankAccountService.getAccountById("CC1");
            BankAccount acc2 = bankAccountService.getAccountById("CC2");
            System.out.println(DataTransformationUtils.toJson(acc1));
            System.out.println(DataTransformationUtils.toJson(acc2));
            System.out.println("============Debit===========");
            bankAccountService.debit(acc1.getAccountId(), 2000);
            System.out.println(DataTransformationUtils.toJson(acc1));
            System.out.println("==========transfer==============");
            bankAccountService.transfer(acc1.getAccountId(), acc2.getAccountId(),4000);

            System.out.println(DataTransformationUtils.toJson(acc1));
            System.out.println(DataTransformationUtils.toJson(acc2));
        } catch (AccountNotFoundException | BalanceNotSufficentException e) {
            throw new RuntimeException(e);
        }
    }
}
