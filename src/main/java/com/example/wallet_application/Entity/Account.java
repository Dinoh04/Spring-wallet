package com.example.wallet_application.Entity;

import java.sql.Timestamp;
import java.time.LocalDate;


public class Account {
    private int idaccounts;
    private String accountsname;
    private double accountsbalance;
    private LocalDate lastupdate;
    private AccounType accounType;
    private int idcurrency;

    public Account(int idaccounts, String accountsname, double accountsbalance, LocalDate lastupdate, AccounType accounType, int idcurrency) {
        this.idaccounts = idaccounts;
        this.accountsname = accountsname;
        this.accountsbalance = accountsbalance;
        this.lastupdate = lastupdate;
        this.accounType = accounType;
        this.idcurrency = idcurrency;
    }

    public int getIdaccounts() {
        return idaccounts;
    }

    public void setIdaccounts(int idaccounts) {
        this.idaccounts = idaccounts;
    }

    public String getAccountsname() {
        return accountsname;
    }

    public void setAccountsname(String accountsname) {
        this.accountsname = accountsname;
    }

    public double getAccountsbalance() {
        return accountsbalance;
    }

    public void setAccountsbalance(double accountsbalance) {
        this.accountsbalance = accountsbalance;
    }

    public LocalDate getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(LocalDate lastupdate) {
        this.lastupdate = lastupdate;
    }

    public AccounType getAccounType() {
        return accounType;
    }

    public void setAccounType(AccounType accounType) {
        this.accounType = accounType;
    }

    public int getIdcurrency() {
        return idcurrency;
    }

    public void setIdcurrency(int idcurrency) {
        this.idcurrency = idcurrency;
    }
}
