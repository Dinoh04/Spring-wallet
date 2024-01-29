package com.example.wallet_application.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Currency {
    private int idcurrency;
    private String currencyName;
    private String currencyCode;
}
