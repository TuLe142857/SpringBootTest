package edu.ptithcm.AuthTest.model;

import java.util.ArrayList;

public class AccountSample {
    public static ArrayList<Account> accounts;
    static{
        accounts = new ArrayList<>();
        accounts.add(Account.builder().id(1).userName("Admin1").password("Admin1").role(Account.Role.ADMIN).build());
        accounts.add(Account.builder().id(2).userName("Admin2").password("Admin2").role(Account.Role.ADMIN).build());
        accounts.add(Account.builder().id(3).userName("Tutor1").password("Tutor1").role(Account.Role.TUTOR).build());
        accounts.add(Account.builder().id(4).userName("Tutor1").password("Tutor2").role(Account.Role.TUTOR).build());
        accounts.add(Account.builder().id(5).userName("Customer1").password("Customer1").role(Account.Role.CUSTOMER).build());
        accounts.add(Account.builder().id(6).userName("Customer2").password("Customer2").role(Account.Role.CUSTOMER).build());
    }
}
