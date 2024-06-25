package org.example;

import org.example.business.BankAccountService;
import org.example.business.BankAccountServiceImp;
import org.example.exceptions.AccountNotFoundException;
import org.example.model.BankAccount;
import org.example.model.CurrentAccount;
import org.example.utils.DataTransformationUtils;

import java.util.List;
import java.util.stream.Stream;

public class Application2 {
    public static void main(String[] args) {
        BankAccountService bankAccountService = new BankAccountServiceImp();
        bankAccountService.addRandomData(10);

        List<BankAccount> bankAccounts = bankAccountService.getAllBankAccounts();
        /*bankAccounts.forEach(acc-> System.out.println(acc));
        System.out.println(DataTransformationUtils.toJson(bankAccounts));*/
         bankAccounts
                .stream()
                .map(DataTransformationUtils::toJson)
                .forEach(System.out::println);

         BankAccount bankAccount = new CurrentAccount(3333, "MAD",5500);
         bankAccount.setAccountId("CC2");

         bankAccountService.addBankAccount(bankAccount);
        try {
            System.out.println(DataTransformationUtils.toJson(bankAccountService.getAccountById("CC1")));
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
