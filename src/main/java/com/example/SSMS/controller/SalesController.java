package com.example.SSMS.controller;

import com.example.SSMS.dtos.SalesRequestDTO;
import com.example.SSMS.model.Sale;
import com.example.SSMS.service.SaleServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sale")
@RequiredArgsConstructor
public class SalesController {

    @Autowired
    private SaleServiceI saleServiceI;

    @PostMapping("")
    public ResponseEntity<Sale> createNewSale(@RequestBody SalesRequestDTO req){
        try {
            return ResponseEntity.ok(saleServiceI.createOrder(req));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Sale>> getAllSales(){
        List<Sale> sales = saleServiceI.getAllSales();
        if(sales != null){
            return new ResponseEntity<>(sales,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{orderNo}")
    public ResponseEntity<Sale> getSaleByOrderNo(@PathVariable String orderNo){
        Sale sale = saleServiceI.getSaleByOrderNo(orderNo);
        if(orderNo == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(sale == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return ResponseEntity.ok(sale);
        }
    }
}
