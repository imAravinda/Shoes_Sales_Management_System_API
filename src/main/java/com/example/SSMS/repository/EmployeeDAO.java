package com.example.SSMS.repository;

import com.example.SSMS.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDAO extends JpaRepository<Employee,Integer> {
    Employee findByEmail(String email);
}
