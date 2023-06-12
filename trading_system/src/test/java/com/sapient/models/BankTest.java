package com.sapient.models;

import com.sapient.models.Bank;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.* ;

class BankTest{
    private static Bank bank ;
    @BeforeAll
    private static void createBankInstance(){
        bank = new Bank() ;
    }

    @Test
    void bankNotNullTest(){
        assertNotNull(bank);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "Bank.csv" , numLinesToSkip = 0)
    void bankCSVTest(String bankName, int nostroAccountInformation,int deskCode , String treasuryInformation ){
        bank.setBankName(bankName);
        bank.setNostroAccountInformation(nostroAccountInformation);
        bank.setDeskCode(deskCode);
        bank.setTreasuryInformation(treasuryInformation);
        assertNotNull(bank.getNostroAccountInformation());
        assertNotNull(bank.getTreasuryInformation());
        assertNotNull(bank.getBankName());
        assertNotNull(bank.getDeskCode());
    }
}