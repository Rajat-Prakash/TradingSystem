package com.sapient.dao;

import com.sapient.facades.CurrencyFacade;
import com.sapient.helpers.PostgresHelper;
import com.sapient.models.Currency;

import java.sql.*;
import java.util.ResourceBundle;

public class CurrencyPostgresImpl implements CurrencyFacade {
    private ResourceBundle resourceBundle;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;
    private boolean status;
    private String query;
    public CurrencyPostgresImpl() throws SQLException {
        this.resourceBundle = ResourceBundle.getBundle("db");
        this.connection= PostgresHelper.getConnection();
    }

    @Override
    public boolean addPostgresCurrency(Currency currency) throws SQLException {
        query=resourceBundle.getString("currencyInsertQuery");
        preparedStatement=connection.prepareStatement(query);
        preparedStatement.setString(1,String.valueOf(currency.getCurrencyId()));
        preparedStatement.setString(2,currency.getCurrencyDescription());
        preparedStatement.setString(3,String.valueOf(currency.getCurrencyCode()));
        preparedStatement.setString(4,String.valueOf(currency.getCurrencySymbol()));
        preparedStatement.setString(5,currency.getCountryUsingCurrency());
        int rows=preparedStatement.executeUpdate();
        if (rows>0)
            status=true;
        return status;
    }

    @Override
    public boolean editPostgresCurrency(int id, String currencyDescription) throws SQLException {
        query=resourceBundle.getString("updateCurrencyTreasuryInformationQuery");
        preparedStatement=connection.prepareStatement(query);
        preparedStatement.setString(2,String.valueOf(id));
        preparedStatement.setString(1,currencyDescription);
        int rows=preparedStatement.executeUpdate();
        if (rows>0)
            status=true;
        return status;
    }

    @Override
    public boolean deletePostgresCurrency(int id) throws SQLException {
        query=resourceBundle.getString("deleteCurrencyById");
        preparedStatement=connection.prepareStatement(query);
        preparedStatement.setString(1,String.valueOf(id));
        int rows =preparedStatement.executeUpdate();
        if (rows>0)
            status=true;
        return status;
    }
}
