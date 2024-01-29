package com.example.wallet_application.Controleur;


import com.example.wallet_application.Entity.Currency;
import com.example.wallet_application.Service.CurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class CurrencyControleur {
    private CurrencyService service;

    public CurrencyControleur(CurrencyService service) {
        this.service = service;
    }
@GetMapping("/Currency")
    public List<Currency> getCurrency() throws SQLException{
        return service.FindAllCurrency();
}

}
