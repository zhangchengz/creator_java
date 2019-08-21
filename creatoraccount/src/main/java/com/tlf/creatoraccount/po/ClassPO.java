package com.tlf.creatoraccount.po;

import com.tlf.creatoraccount.pojo.Accounts;

import java.util.List;

public class ClassPO {

   private String id;
   private String name;
   private List<Accounts> accounts;

    public ClassPO() {
    }

    public ClassPO(String id, String name, List<Accounts> accounts) {
        this.id = id;
        this.name = name;
        this.accounts = accounts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Accounts> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Accounts> accounts) {
        this.accounts = accounts;
    }
}
