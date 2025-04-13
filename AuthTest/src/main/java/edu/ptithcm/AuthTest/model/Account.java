package edu.ptithcm.AuthTest.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Account {
    private int id;
    private String userName;
    private String password;
    private String hashedPassword;
    private Role role;

    public static enum Role{
        ADMIN, TUTOR, CUSTOMER

    }

    public static void main(String []args){
        for (Account a : AccountSample.accounts)
            System.out.println(a);
    }

}
