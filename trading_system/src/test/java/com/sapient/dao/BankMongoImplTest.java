package com.sapient.dao;

import com.sapient.exceptions.BankNameException;
import com.sapient.facades.BankFacade;
import com.sapient.models.Bank;
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

public class BankMongoImplTest {
    private BankFacade bankFacade;
    private Bank bank;
    @BeforeEach
    public void createBankDaoInstance(){
        bankFacade=new BankMongoImpl();
        bank=new Bank(1,"SBI",1,1234,"treasuryInfo");
    }

    @Test
    @Tag("dev")
    public void addClaimTest(){
        try {
            assertTrue(bankFacade.addBank(bank));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    @Tag("dev")
    public void updateClaimTest(){
        try {
            assertTrue(bankFacade.editBank( new Bank(1,"SBI",11,1234,"treasuryInfo"),"SBI"));
        } catch (BankNameException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Tag("dev")
    public void deleteClaimTest(){
        try {
            assertTrue(bankFacade.deleteBank("SBI"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    public void unlinkClaimInstance(){
        bank=null;
        bankFacade=null;
    }
}
