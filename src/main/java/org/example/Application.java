package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.business.BankAccountService;
import org.example.business.BankAccountServiceImp;
import org.example.exceptions.AccountNotFoundException;
import org.example.model.BankAccount;
import org.example.model.CurrentAccount;
import org.example.model.SavingAccount;
import org.example.utils.DataTransformationUtils;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        BankAccountService bankAccountService = new BankAccountServiceImp();
        bankAccountService.addBankAccount(new CurrentAccount(3500, "MAD", 4333));
        bankAccountService.addBankAccount(new SavingAccount(3500, "MAD", 2.3));

        List<BankAccount> allAccounts = bankAccountService.getAllBankAccounts();
        bankAccountService.addBankAccount(new CurrentAccount(3500, "MAD", 4333));

        BankAccount firstAccount = allAccounts.get(0);
        firstAccount.setAccountId("CC1");
        System.out.println(DataTransformationUtils.toJson(firstAccount));

        System.out.println("================");
        try {
            System.out.println(DataTransformationUtils.toJson(
                    bankAccountService.getAccountById("CC1")
            ));
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("===============not found======");
        try {
            System.out.println(DataTransformationUtils.toJson(
                    bankAccountService.getAccountById("CC2")
            ));
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
        //allAccounts.forEach(account -> System.out.println(DataTransformationUtils.toJson(account)));
    }
}
