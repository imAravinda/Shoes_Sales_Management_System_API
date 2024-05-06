package com.example.SSMS.service.impl;

import com.example.SSMS.model.Customer;
import com.example.SSMS.repository.CustomerDAO;
import com.example.SSMS.service.CustomerServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements CustomerServiceI {

    @Autowired
    CustomerDAO customerDAO;

    @Override
    public Customer saveNewLoyalityCustomer(Customer request) {
        Customer customer = new Customer();
        customer.setCustomerCode(request.getCustomerCode());
        customer.setCustomerName(request.getCustomerName());
        customer.setGender(request.getGender());
        customer.setDob(request.getDob());
        customer.setLevel(request.getLevel());
        customer.setAddressLine1(request.getAddressLine1());
        customer.setAddressLine2(request.getAddressLine2());
        customer.setCity(request.getCity());
        customer.setState(request.getState());
        customer.setPostalCode(request.getPostalCode());
        customer.setJoinDateAsALoyality(request.getJoinDateAsALoyality());
        customer.setTotalPoint(request.getTotalPoint());
        return customerDAO.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDAO.findAll();
    }

    @Override
    public Customer getCustomerByCode(String code) {
        return customerDAO.findCustomerByCustomerCode(code);
    }

    @Override
    public Customer updateCustomerByCode(String code,Customer updateRequest) {
        updateRequest.setCustomerCode(code);
        return customerDAO.save(updateRequest);
    }


}
