package com.example.wallet_application.Controleur;


import com.example.wallet_application.Entity.Account;
import com.example.wallet_application.Entity.Currency;
import com.example.wallet_application.Service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/Account")
    public List<Account>getAllAccount() throws SQLException {
        return accountService.FindAllAccount();
    }

    @PostMapping("/Account")
    public Account createAccount(@RequestBody Account toSave) throws  SQLException{
        return  accountService.Save(toSave);
    }

    @PostMapping("/Allaccount")
    public  List<Account> postAllAccount(@RequestBody(required = true) List<Account> tosave) throws SQLException {
        return accountService.SaveAll(tosave);
    }
    @DeleteMapping("/Account/{todelete}")
    public void deleteAccount(@PathVariable("todelete") int todelete) throws  SQLException{
        accountService.Delete(todelete);
    }
}
