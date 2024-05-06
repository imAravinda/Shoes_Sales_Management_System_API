package com.example.SSMS.repository;

import com.example.SSMS.model.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsDAO extends JpaRepository<OrderItems,Integer> {
    OrderItems findByItemCode(String itemCode);
}
