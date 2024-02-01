package com.example.wallet_application.Repository;

import com.example.wallet_application.Entity.Currency;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class CurrencyCrudOperations implements CrudOperations<Currency>{
    private Connection connection;

    public CurrencyCrudOperations(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Currency> findAll() throws SQLException {
        List<Currency> allCurrency = new ArrayList<>();
        String sql = "SELECT * FROM Currency";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                allCurrency.add(new Currency(
                        resultSet.getInt("idCurrency"),
                        resultSet.getString("currencyName"),
                        resultSet.getString("currencyCode")
                ));
            }
        }
        return allCurrency;
    }

    @Override
    public List<Currency> saveAll(List<Currency> toSave) throws SQLException {
        List<Currency> savedList = new ArrayList<>();
        for (Currency toSaved : toSave) {
            Currency savedCurrency = save(toSaved);
            savedList.add(savedCurrency);
        }
        return savedList;
    }

    @Override
    public Currency save(Currency toSave) throws SQLException {
        if (toSave.getIdcurrency() == null) {
            // If ID is null, do an insert
            String insertSql = "INSERT INTO Currency (currencyName, currencyCode) VALUES (?, ?)"+ "ON CONFLICT (currencyName, currencyCode) DO NOTHING;";
            try (PreparedStatement insertStatement = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
                insertStatement.setString(1, toSave.getCurrencyName());
                insertStatement.setString(2, toSave.getCurrencyCode());
                insertStatement.executeUpdate();

                try (ResultSet generatedKeys = insertStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        toSave.setIdcurrency(generatedKeys.getInt(1));
                    }
                }
            }
        } else {
            // if ID is not null, do a update
            String updateSql = "UPDATE Currency SET currencyName = ?, currencyCode = ? WHERE idSerial = ?";
            try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
                updateStatement.setString(1, toSave.getCurrencyName());
                updateStatement.setString(2, toSave.getCurrencyCode());
                updateStatement.setInt(3, toSave.getIdcurrency());
                updateStatement.executeUpdate();
            }
        }

        return toSave;
    }

    @Override
    public void delete(int toDelete) throws SQLException {
        String sql = "DELETE FROM Currency WHERE idcurrency = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, toDelete);
            preparedStatement.executeUpdate();
        }

    }

}
