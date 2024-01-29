package com.example.wallet_application.Service;


import com.example.wallet_application.Entity.Currency;
import com.example.wallet_application.Repository.CurrencyCrudOperations;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CurrencyService {
    private CurrencyCrudOperations repository;

    public CurrencyService(CurrencyCrudOperations repository) {
        this.repository = repository;
    }

    public List<Currency> FindAllCurrency() throws SQLException {
        return repository.findAll();
    }
}
