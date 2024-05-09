package com.example.SSMS.service.impl;

import com.example.SSMS.dtos.EmployeeRequestDTO;
import com.example.SSMS.model.AppUser;
import com.example.SSMS.model.Employee;
import com.example.SSMS.repository.EmployeeDAO;
import com.example.SSMS.repository.UserDAO;
import com.example.SSMS.service.EmployeeServiceI;
import com.example.SSMS.utill.Utills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
public class EmployeeService implements EmployeeServiceI {
    @Autowired
    EmployeeDAO employeeDAO;
    @Autowired
    private Utills utills;

    @Override
    @Transactional
    public Employee createEmployee(EmployeeRequestDTO req) {
        Employee existingEmployee = employeeDAO.findByEmail(req.getEmail());
        if(existingEmployee == null){
            Employee employee = new Employee();
            employee.setEmployeeCode(generateEmployeeCode());
            employee.setEmployeeName(req.getEmployeeName());
            String image = utills.convertToBase64(req.getEmployeePic());
            employee.setEmployeePic(image);
            employee.setAccessRole(req.getAccessRole());
            employee.setDob(req.getDob());
            employee.setStatus(req.getStatus());
            employee.setDesignation(req.getDesignation());
            employee.setDateOfJoin(req.getDateOfJoin());
            employee.setGender(req.getGender());
            employee.setAttachedBranch(req.getAttachedBranch());
            employee.setAddressLine1(req.getAddressLine1());
            employee.setAddressLine2(req.getAddressLine2());
            employee.setCity(req.getCity());
            employee.setState(req.getState());
            employee.setPostalCode(req.getPostalCode());
            employee.setContactNo(req.getContactNo());
            employee.setEmergancyInformer(req.getEmergancyInformer());
            employee.setEmergancyContactDetails(req.getEmergancyContactDetails());
            employee.setEmail(req.getEmail());
            AppUser appUser = new AppUser();
            appUser.setEmail(employee.getEmail());
            appUser.setPassword(new BCryptPasswordEncoder().encode("pwd1234567"));
            appUser.setRole(employee.getAccessRole());
            appUser.setEmployee(employee);
            employee.setAppUser(appUser);
            employeeDAO.save(employee);
            return employee;
        }
        else{
            throw new RuntimeException("Employee with email " + req.getEmail() + " already exists.");
        }
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        return employeeDAO.findByEmail(email);
    }

    @Override
    public Employee updateEmployee(String email,EmployeeRequestDTO req){
        Employee employee = employeeDAO.findByEmail(email);
        if(employee != null){
            employee.setEmployeeName(req.getEmployeeName());
            String image = utills.convertToBase64(req.getEmployeePic());
            employee.setEmployeePic(image);
            employee.setAccessRole(req.getAccessRole());
            employee.setDob(req.getDob());
            employee.setStatus(req.getStatus());
            employee.setDesignation(req.getDesignation());
            employee.setDateOfJoin(req.getDateOfJoin());
            employee.setGender(req.getGender());
            employee.setAttachedBranch(req.getAttachedBranch());
            employee.setAddressLine1(req.getAddressLine1());
            employee.setAddressLine2(req.getAddressLine2());
            employee.setCity(req.getCity());
            employee.setState(req.getState());
            employee.setPostalCode(req.getPostalCode());
            employee.setContactNo(req.getContactNo());
            employee.setEmergancyInformer(req.getEmergancyInformer());
            employee.setEmergancyContactDetails(req.getEmergancyContactDetails());
            employee.setEmail(req.getEmail());
            AppUser appUser = new AppUser();
            appUser.setEmail(employee.getEmail());
            appUser.setPassword(new BCryptPasswordEncoder().encode("pwd1234567"));
            appUser.setRole(employee.getAccessRole());
            appUser.setEmployee(employee);
            employee.setAppUser(appUser);
            employeeDAO.save(employee);
            return employee;
        }
        else{
            return null;
        }
    }

    private String generateEmployeeCode(){
        int empNo = new Random().nextInt(10000);
        return "EMP"+empNo;
    }
}