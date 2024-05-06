package com.example.SSMS.controller;

import com.example.SSMS.model.Customer;
import com.example.SSMS.service.CustomerServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    CustomerServiceI customerServiceI;

    @PostMapping("")
    public ResponseEntity<Customer> saveNewCustomer(Customer req){
        return ResponseEntity.ok(customerServiceI.saveNewLoyalityCustomer(req));
    }

}
