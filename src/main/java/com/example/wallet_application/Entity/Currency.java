package com.example.wallet_application.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class Currency {
    private Integer idcurrency;
    private String currencyName;
    private String currencyCode;

    public Currency(Integer idcurrency, String currencyName, String currencyCode) {
        this.idcurrency = idcurrency;
        this.currencyName = currencyName;
        this.currencyCode = currencyCode;
    }

    public Integer getIdcurrency() {
        return idcurrency;
    }

    public void setIdcurrency(Integer idcurrency) {
        this.idcurrency = idcurrency;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
