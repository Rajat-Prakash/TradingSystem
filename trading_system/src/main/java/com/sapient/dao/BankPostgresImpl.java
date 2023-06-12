package com.sapient.dao;

import com.sapient.facades.BankFacade;
import com.sapient.helpers.PostgresHelper;
import com.sapient.models.Bank;

import java.sql.*;
import java.util.ResourceBundle;

public class BankPostgresImpl implements BankFacade {
    private ResourceBundle resourceBundle;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;
    private boolean status;
    private String query;
    public BankPostgresImpl() throws SQLException {
        this.resourceBundle = ResourceBundle.getBundle("db");
        this.connection= PostgresHelper.getConnection();
    }

    @Override
    public boolean addPostgresBank(Bank bank) throws SQLException {
        query=resourceBundle.getString("bankInsertQuery");
        preparedStatement=connection.prepareStatement(query);
        preparedStatement.setString(1,String.valueOf(bank.getBankId()));
        preparedStatement.setString(2,bank.getBankName());
        preparedStatement.setString(3,String.valueOf(bank.getNostroAccountInformation()));
        preparedStatement.setString(4,String.valueOf(bank.getDeskCode()));
        preparedStatement.setString(5,bank.getTreasuryInformation());
        int rows=preparedStatement.executeUpdate();
        if (rows>0)
            status=true;
        return status;
    }

    @Override
    public boolean editPostgresBank(int bankId, String treasuryInformation) throws SQLException {
        query=resourceBundle.getString("updateBankTreasuryInformationQuery");
        preparedStatement=connection.prepareStatement(query);
        preparedStatement.setString(2,String.valueOf(bankId));
        preparedStatement.setString(1,String.valueOf(treasuryInformation));
        int rows=preparedStatement.executeUpdate();
        if (rows>0)
            status=true;
        return status;
    }

    @Override
    public boolean deletePostgresBank(int bankId) throws SQLException {
        query=resourceBundle.getString("deleteBankById");
        preparedStatement=connection.prepareStatement(query);
        preparedStatement.setString(1,String.valueOf(bankId));
        int rows =preparedStatement.executeUpdate();
        if (rows>0)
            status=true;
        return status;
    }
}
