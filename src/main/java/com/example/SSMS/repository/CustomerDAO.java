package com.example.SSMS.repository;

import com.example.SSMS.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<Customer,Integer> {
    Customer findCustomerByCustomerCode(String customerCode);
}
