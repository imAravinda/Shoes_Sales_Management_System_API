package com.example.SSMS.dtos;

import com.example.SSMS.model.Customer;
import com.example.SSMS.model.OrderItems;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class SalesRequestDTO {
    private String customerName;
    private String paymentMethod;
    private boolean hasLoyalityCard;
    private double addedPoints;
    private String cashierName;
    private ArrayList<OrderItems> items;
    private Customer customerCode;
}
