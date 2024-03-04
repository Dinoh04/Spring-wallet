package com.example.wallet_application.Repository;

import com.example.wallet_application.Entity.AccounType;
import com.example.wallet_application.Entity.Account;
import com.example.wallet_application.Entity.Currency;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountCrudOperations implements CrudOperations<Account>{

    private Connection connection;

    public AccountCrudOperations(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Account> findAll() throws SQLException {
        List<Account> allAccount = new ArrayList<>();
        String sql = "SELECT * FROM Account";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                allAccount.add(new Account(
                        resultSet.getInt("idaccounts"),
                        resultSet.getString("accountsname"),
                        resultSet.getDouble("accountsbalance"),
                        resultSet.getDate("lastUpdate").toLocalDate(),
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
        if (false) {
            // If ID is null, do an insert
            String insertSql = "INSERT INTO Accounts (accountsName, accountsBalance, lastUpdate, idCurrency, accountType) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement insertStatement = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
                insertStatement.setString(1, toSave.getAccountsname());
                insertStatement.setDouble(2, toSave.getAccountsbalance());
                insertStatement.setDate(3, Date.valueOf(toSave.getLastupdate()));
                insertStatement.setInt(4, toSave.getIdcurrency());
                insertStatement.setObject(5, toSave.getAccounType(), Types.OTHER);
                insertStatement.executeUpdate();

                try (ResultSet generatedKeys = insertStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        toSave.getIdaccounts(generatedKeys.getInt(1));
                    }
                }
            }
        } else {
            // if idAccounts  is not null, do an update
            String updateSql = "UPDATE Accounts SET accountsName = ?, accountsBalance = ?, lastUpdate = ?, idCurrency = ?, accountType = ? WHERE idAccounts = ?";
            try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
                updateStatement.setString(1, toSave.getAccountsname());
                updateStatement.setDouble(2, toSave.getAccountsbalance());
                updateStatement.setDate(3, Date.valueOf(toSave.getLastupdate()));
                updateStatement.setInt(4, toSave.getIdcurrency());
                updateStatement.setObject(5, toSave.getAccounType(), Types.OTHER);
                updateStatement.setInt(6, toSave.getIdaccounts());
                updateStatement.executeUpdate();
            }
        }

        return toSave;
    }

    @Override
    public void delete(int toDelete) throws SQLException {

    }
}
