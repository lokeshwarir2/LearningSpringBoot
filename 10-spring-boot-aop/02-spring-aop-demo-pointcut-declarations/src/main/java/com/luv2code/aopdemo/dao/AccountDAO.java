package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;

import java.util.List;

public interface AccountDAO {
    public void setCode(String code);
    public String getCode();
    public void setName(String name);
    public String getName();
    void addAccount();
    List<Account> findAccount();
    List<Account> findAccount(boolean tripWire);
}
