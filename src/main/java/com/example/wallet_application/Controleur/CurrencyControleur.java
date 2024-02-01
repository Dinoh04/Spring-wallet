package com.example.wallet_application.Controleur;


import com.example.wallet_application.Entity.Currency;
import com.example.wallet_application.Service.CurrencyService;
import org.springframework.web.bind.annotation.*;

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
@PostMapping("/Currency")
    public  Currency postCurrency(@RequestBody(required = true) Currency tosave) throws SQLException{
        return  service.Save(tosave);
}

@PostMapping("/Allcurrency")
    public  List<Currency> postAllCurrency(@RequestBody(required = true) List<Currency> tosave) throws SQLException{
        return service.SaveAll(tosave);
}

@DeleteMapping("/Currency/{todelete}")
    public void deleteCurrency(@PathVariable("todelete") int todelete) throws  SQLException{
         service.Delete(todelete);
}

}
