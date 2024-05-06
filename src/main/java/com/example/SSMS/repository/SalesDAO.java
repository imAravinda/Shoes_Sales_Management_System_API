package com.example.SSMS.repository;

import com.example.SSMS.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesDAO extends JpaRepository<Sale,Integer> {
    Sale findByOrderNo(String orderNo);
}
