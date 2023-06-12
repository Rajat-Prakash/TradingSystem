package com.sapient.facades;

import com.sapient.models.Currency;

import java.io.IOException;
import java.sql.SQLException;

public interface CurrencyFacade {
    default boolean addCurrency(Currency currency) throws IOException{
        return false;
    }
    default boolean addPostgresCurrency(Currency currency) throws SQLException {
        return false;
    }
    default boolean editCurrency(int id, Currency currency) throws IOException{
        return false;
    }
    default boolean editPostgresCurrency(int id, String currencyDescription) throws SQLException {
        return false;
    }
    default boolean deleteCurrency(int id) throws IOException{
        return false;
    }
    default boolean deletePostgresCurrency(int id) throws SQLException {
        return false;
    }
}
