package com.example.wallet_application.Repository;

import com.example.wallet_application.Entity.Currency;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        return null;
    }

    @Override
    public Currency save(Currency toSave) throws SQLException {
        return null;
    }

    @Override
    public Currency delete(Currency toDelete) throws SQLException {
        return null;
    }
}
