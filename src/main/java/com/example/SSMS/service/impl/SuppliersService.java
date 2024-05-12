package com.example.SSMS.service.impl;

import com.example.SSMS.dtos.SupplierRequestDTO;
import com.example.SSMS.model.AppUser;
import com.example.SSMS.model.Employee;
import com.example.SSMS.model.Supplier;
import com.example.SSMS.model.enums.Category;
import com.example.SSMS.repository.SupplierDAO;
import com.example.SSMS.service.SuppliersServiceI;
import com.example.SSMS.utill.Utills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class SuppliersService implements SuppliersServiceI {

    @Autowired
    SupplierDAO supplierDAO;
    @Autowired
    Utills utills;
    @Override
    public Supplier createSupplier(SupplierRequestDTO req) {
        Supplier existingSupplier = supplierDAO.findByEmail(req.getEmail());
        if(existingSupplier == null){
            Supplier supplier = new Supplier();
            supplier.setSupplierCode(utills.generateCode("SUP"));
            supplier.setSupplierName(req.getSupplierName());
            supplier.setCategory(req.getCategory());
            supplier.setAddressLine1(req.getAddressLine1());
            supplier.setAddressLine2(req.getAddressLine2());
            supplier.setCity(req.getCity());
            supplier.setState(req.getState());
            supplier.setPostalCode(req.getPostalCode());
            if(supplier.getCategory().equals(Category.LOCAL)){
                supplier.setCountry("Sri Lanka");
            }
            else{
                supplier.setCountry(req.getCountry());
            }
            supplier.setMobileNo(req.getMobileNo());
            supplier.setLandLineNo(req.getLandLineNo());
            supplier.setEmail(req.getEmail());
            supplierDAO.save(supplier);
            return supplier;
        }
        else{
            throw new RuntimeException("Supplier with email " + req.getEmail() + " already exists.");
        }
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierDAO.findAll();
    }

    @Override
    public Supplier getSupplierByEmail(String email) {
        return supplierDAO.findByEmail(email);
    }

    @Override
    public Supplier updateSupplier(String email, SupplierRequestDTO req) {
        Supplier existingSuppliier = supplierDAO.findByEmail(email);
        if (existingSuppliier != null) {
            if (!email.equals(req.getEmail()) && supplierDAO.findByEmail(req.getEmail()) != null) {
                throw new RuntimeException("Employee with email " + req.getEmail() + " already exists.");
            }
            existingSuppliier.setSupplierName(req.getSupplierName());
            existingSuppliier.setCategory(req.getCategory());
            existingSuppliier.setAddressLine1(req.getAddressLine1());
            existingSuppliier.setAddressLine2(req.getAddressLine2());
            existingSuppliier.setCity(req.getCity());
            existingSuppliier.setState(req.getState());
            existingSuppliier.setPostalCode(req.getPostalCode());
            existingSuppliier.setCountry(req.getCountry());
            existingSuppliier.setMobileNo(req.getMobileNo());
            existingSuppliier.setLandLineNo(req.getLandLineNo());
            existingSuppliier.setEmail(req.getEmail());
            supplierDAO.save(existingSuppliier);
            return existingSuppliier;
        } else {
            throw new RuntimeException("Employee with email " + email + " not found.");
        }
    }


}
