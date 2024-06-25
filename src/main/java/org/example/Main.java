package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.BankAccount;
import org.example.model.CurrentAccount;
import org.example.model.SavingAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {

        System.out.println("============arraylist=========");

        List<BankAccount> bankAccountList = new ArrayList<>();
        bankAccountList.add(new CurrentAccount(3500, "MAD", 4333));

        for(BankAccount acount:bankAccountList){
            System.out.println(toJson(acount));
        }

        System.out.println("============Map==========");

        Map<String, BankAccount> bankAccountMap = new HashMap<>();
        bankAccountMap.put("cc1", new SavingAccount(3500, "MAD", 2.3));
        bankAccountMap.put("cc2", new SavingAccount(5500, "MAD", 3.4));

        bankAccountMap.put("cc3", new SavingAccount(5500, "MAD", 4.1));

        for(String key: bankAccountMap.keySet()){
            System.out.println(toJson(bankAccountMap.values()));
        }

    }
    public static String toJson(Object o) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
    }
}