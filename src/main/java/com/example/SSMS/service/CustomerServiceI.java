package com.example.SSMS.service;

import com.example.SSMS.model.Customer;

import java.util.List;

public interface CustomerServiceI {
    Customer saveNewLoyalityCustomer(Customer request);

    List<Customer> getAllCustomers();

    Customer getCustomerByCode(String code);

    Customer updateCustomerByCode(String code,Customer request);
}
