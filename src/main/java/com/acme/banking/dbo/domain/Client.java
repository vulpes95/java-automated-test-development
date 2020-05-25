package com.acme.banking.dbo.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class Client {
    private UUID id;
    private String name;
    private List<Account> accounts = new ArrayList<>();

    public Client(UUID id, String name) {
        if (id == null) throw new IllegalArgumentException();

        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addAccount(Account account){
        if (account == null) throw new IllegalArgumentException();
        account.setClient(this);
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
