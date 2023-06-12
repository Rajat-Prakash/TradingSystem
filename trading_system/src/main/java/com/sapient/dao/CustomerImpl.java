package com.sapient.dao;

import com.sapient.exceptions.BankNameException;
import com.sapient.facades.CustomerFacade;
import com.sapient.models.Bank;
import com.sapient.models.Customer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerImpl implements CustomerFacade {
    private List<Customer> customerData=new ArrayList<>();

    @Override
    public void addCustomer(Customer customer) {
        this.customerData.add(customer);
    }

    @Override
    public void editCustomer(Customer customer, int customerId) {
        for(int i=0; i<this.customerData.size(); i++){
            if(this.customerData.get(i).getCustomerID() == customerId){
                    this.customerData.set(i,customer);
            }
        }
    }

    @Override
    public void deleteCustomer(int customerId) {
        for(int i=0; i<this.customerData.size(); i++){
            if(this.customerData.get(i).getCustomerID() == customerId){
                this.customerData.remove(i);
                 break;
            }
        }
    }
}
