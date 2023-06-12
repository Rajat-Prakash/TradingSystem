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

public class CountryTest {

    private static Country country;

    @BeforeAll
    public static void createCountryInstance(){
        country=new Country();
    }

    @Test
    @DisplayName("Country Not null test")
    public void countryNotNullTest(){
        assertNotNull(country);
    }

    @ParameterizedTest
    @ValueSource(ints={1,2,3})
    public void countryCodeProperTest(int data){
        country.setCountryCode(data);
        assertTrue(country.getCountryCode()>0 && country.getCountryCode()<250);
    }


}
