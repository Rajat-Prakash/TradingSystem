package com.sapient.models;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;


        import org.junit.jupiter.api.*;
        import org.junit.jupiter.params.ParameterizedTest;
        import org.junit.jupiter.params.provider.CsvFileSource;
        import org.junit.jupiter.params.provider.ValueSource;


        import java.time.LocalDate;
        import java.util.concurrent.TimeUnit;

        import static junit.framework.Assert.assertNotNull;
        import static junit.framework.Assert.assertTrue;

public class CurrencyTest {

    private static Currency currency;

    @BeforeAll
    public static void createClaimInstance(){
        currency=new Currency();
    }

    @Test
    @DisplayName("Claim Not null test")
    public void claimNotNullTest(){
        assertNotNull(currency);
    }

    @ParameterizedTest
    @ValueSource(ints={4354,3443,9843})
    public void currencyIdNotZeroTest(int data){
        currency.setCurrencyId(data);
        assertTrue(currency.getCurrencyId()>0);
    }

    @ParameterizedTest
    @ValueSource(ints = {1223,1224,1225})
    public void claimDateNotCurrentDateTest(int data){
        currency.setCurrencyCode(data);
        assertTrue(currency.getCurrencyCode()>1000);
    }
    @ParameterizedTest
    @Timeout(unit = TimeUnit.SECONDS,value=5)
    @CsvFileSource(resources = "claims.csv",numLinesToSkip = 1)
    public void testWithCsvFileSource(int currencyId,String currencyDescription,int currencyCode,Symbol currencySymbol,String countryUsingCurrency){
        currency.setCurrencyId(currencyId);
        currency.setCurrencyDescription(currencyDescription);
        currency.setCurrencyCode(currencyCode);
        currency.setCurrencySymbol(currencySymbol);
        currency.setCountryUsingCurrency(countryUsingCurrency);
        assertTrue(currency.getCurrencyId()>0);
    }
}
