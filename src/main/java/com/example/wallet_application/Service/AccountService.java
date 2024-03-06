package com.example.wallet_application.Service;


import com.example.wallet_application.Entity.Account;
import com.example.wallet_application.Entity.Currency;
import com.example.wallet_application.Repository.AccountCrudOperations;
import com.example.wallet_application.Repository.CurrencyCrudOperations;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AccountService {
    private AccountCrudOperations repository;

    public AccountService(AccountCrudOperations repository) {
        this.repository = repository;
    }



    public List<Account> FindAllAccount() throws SQLException {
        return repository.findAll();
    }
    public Account Save(Account tosave) throws SQLException {
        return repository.save(tosave);
    }
    public  List<Account> SaveAll(List<Account> toSave) throws  SQLException{
        return  repository.saveAll(toSave);
    }

    public void Delete(int todelete) throws  SQLException{
        repository.delete(todelete);
    }
}
