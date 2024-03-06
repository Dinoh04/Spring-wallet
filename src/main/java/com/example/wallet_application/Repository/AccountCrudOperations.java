package com.example.wallet_application.Repository;

import com.example.wallet_application.Entity.AccounType;
import com.example.wallet_application.Entity.Account;
import com.example.wallet_application.Entity.Currency;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountCrudOperations implements CrudOperations<Account>{

    private Connection connection;

    public AccountCrudOperations(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Account> findAll() throws SQLException {
        List<Account> allAccount = new ArrayList<>();
        String sql = "SELECT * FROM Accounts";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                allAccount.add(new Account(
                        resultSet.getInt("idaccounts"),
                        resultSet.getString("accountsname"),
                        resultSet.getDouble("accountsbalance"),
                        resultSet.getTimestamp("lastUpdate"),
                        AccounType.valueOf(resultSet.getString("AccountType")),
                        resultSet.getInt("idCurrency")

                ));
            }
        }
        return allAccount;
    }

    @Override
    public List<Account> saveAll(List<Account> toSave) throws SQLException {
        List<Account> savedList = new ArrayList<>();
        for (Account toSaved : toSave) {
            Account savedAccount = save(toSaved);
            savedList.add(savedAccount);
        }
        return savedList;
    }

    @Override
    public Account save(Account toSave) throws SQLException {


            String insertSql = "INSERT INTO Accounts (accountsName, accountsBalance, lastUpdate, idCurrency, accountType) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement insertStatement = connection.prepareStatement(insertSql)) {
                insertStatement.setString(1, toSave.getAccountsname());
                insertStatement.setDouble(2, toSave.getAccountsbalance());
                insertStatement.setTimestamp(3, toSave.getLastupdate());
                insertStatement.setInt(4, toSave.getIdcurrency());
                insertStatement.setObject(5, toSave.getAccounType(), Types.OTHER);
                insertStatement.executeUpdate();


            }


        return toSave;
    }

    @Override
    public void delete(int toDelete) throws SQLException {

    }
}
