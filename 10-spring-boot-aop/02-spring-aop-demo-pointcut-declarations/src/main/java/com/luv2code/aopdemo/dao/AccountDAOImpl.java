package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{
    private String name;
    private String code;

    public String getName() {
        System.out.println("get name");
        return name;
    }

    public void setName(String name) {
        System.out.println("set name");
        this.name = name;
    }

    public String getCode() {
        System.out.println("get code");
        return code;
    }

    public void setCode(String code) {
        System.out.println("set code");
        this.code = code;
    }

    @Override
    public void addAccount() {
        System.out.println("Adding an account");
    }

    @Override
    public List<Account> findAccount() {
        return findAccount(false);
    }

    @Override
    public List<Account> findAccount(boolean tripWire) {
        if(tripWire){
            throw new RuntimeException("No nono");
        }
        List<Account> myAccounts=new ArrayList<>();
        Account a1=new Account("loki","1");
        Account a2=new Account("vicky","2");
        myAccounts.add(a1);
        myAccounts.add(a2);
        return myAccounts;
    }
}
