package com.sapient.dao;

import com.sapient.exceptions.BankNameException;
import com.sapient.facades.BankFacade;
import com.sapient.facades.CurrencyFacade;
import com.sapient.models.Bank;
import com.sapient.models.Currency;
import com.sapient.models.Symbol;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CurrencyMongoImplTest {
    private CurrencyFacade currencyFacade;
    private Currency currency;
    @BeforeEach
    public void createBankDaoInstance(){
        currencyFacade=new CurrencyMongoImpl();
        currency=new Currency(1,"Indian Currency",101, Symbol.RUPEE,"India");
    }

    @Test
    @Tag("dev")
    public void addCurrencyTest(){
        try {
            assertTrue(currencyFacade.addCurrency(currency));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    @Tag("dev")
    public void updateCurrencyTest(){
        try {
            assertTrue(currencyFacade.editCurrency(1,new Currency(1,"Indian Currency Updated",101, Symbol.RUPEE,"India")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Tag("dev")
    public void deleteClaimTest(){
        try {
            assertTrue(currencyFacade.deleteCurrency(1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    public void unlinkClaimInstance(){
        currency=null;
        currencyFacade=null;
    }
}
