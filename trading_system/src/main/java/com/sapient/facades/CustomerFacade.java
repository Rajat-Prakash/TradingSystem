package com.sapient.facades;

import com.sapient.models.Customer;

public interface CustomerFacade {
    public void addCustomer(Customer customer);
    public void editCustomer(Customer customer,int customerId);
    public void deleteCustomer(int customerId);
}
