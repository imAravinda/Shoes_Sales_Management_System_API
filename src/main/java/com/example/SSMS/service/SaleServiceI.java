package com.example.SSMS.service;

import com.example.SSMS.dtos.SalesRequestDTO;
import com.example.SSMS.model.Sale;

import java.util.List;

public interface SaleServiceI {
    Sale createOrder(SalesRequestDTO saleRequest);

    List<Sale> getAllSales();

    Sale getSaleByOrderNo(String orderNo);

    Sale updateSaleByOrderNo(String orderNo,SalesRequestDTO updateSaleRequest);
}
