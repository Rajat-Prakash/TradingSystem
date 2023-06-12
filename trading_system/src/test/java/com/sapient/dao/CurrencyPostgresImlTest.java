package com.sapient.dao;

import com.sapient.facades.BankFacade;
import com.sapient.facades.CurrencyFacade;
import com.sapient.models.Bank;
import com.sapient.models.Currency;
import com.sapient.models.Symbol;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CurrencyPostgresImlTest {
    private CurrencyFacade currencyFacade;
    private Currency currency;



    @BeforeEach
    public void createBankDaoInstance(){
        currency=new Currency(1,"Currency OF india",
                21, Symbol.RUPEE,
                "INDIA");
        try {
            currencyFacade=new CurrencyPostgresImpl();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }



    }

    @Test
    @Tag("dev")
    public void addCurrencyTest(){

        try {
            assertTrue(currencyFacade.addPostgresCurrency(currency));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    @Tag("dev")
    public void updateBankTest(){

        try {
            assertTrue(currencyFacade.editPostgresCurrency(1,"updated india description"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @Tag("dev")
    public void deleteBankByIdTest(){

        try {
            assertTrue(currencyFacade.deletePostgresCurrency(1));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    @AfterEach
    public void unLinkClaimInstances(){
        currency=null;
        currencyFacade=null;
    }
}
