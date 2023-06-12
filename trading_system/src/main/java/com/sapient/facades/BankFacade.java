package com.sapient.facades;

import com.sapient.exceptions.BankNameException;
import com.sapient.models.Bank;

import java.io.IOException;
import java.sql.SQLException;

public interface BankFacade {
    default boolean addBank(Bank bank) throws IOException{
        return false;
    }
    default boolean addPostgresBank(Bank bank) throws SQLException {
        return false;
    }
    default boolean editBank(Bank bank,String name) throws BankNameException, IOException{
        return false;
    }
    default boolean editPostgresBank(int bankId, String treasuryInformation) throws SQLException {
        return false;
    }
    default boolean deleteBank(String name) throws IOException{
        return false;
    }
    default boolean deletePostgresBank(int bankId) throws SQLException {
        return false;
    }
}
