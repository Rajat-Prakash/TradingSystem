package com.sapient.dao;

import com.sapient.facades.BankFacade;
import com.sapient.models.Bank;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BankPostgresImplTest {
    private BankFacade bankFacade;
    private Bank bank;



    @BeforeEach
    public void createBankDaoInstance(){
        bank=new Bank(1,"SBI",
                21,12234,
                "treasure info");
        try {
            bankFacade=new BankPostgresImpl();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }



    }

    @Test
    @Tag("dev")
    public void addBankTest(){

        try {
            assertTrue(bankFacade.addPostgresBank(bank));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    @Tag("dev")
    public void updateBankTest(){

        try {
            assertTrue(bankFacade.editPostgresBank(1,"updated treasure "));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @Tag("dev")
    public void deleteBankByIdTest(){

        try {
            assertTrue(bankFacade.deletePostgresBank(1));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    @AfterEach
    public void unLinkClaimInstances(){
        bank=null;
        bankFacade=null;
    }
}