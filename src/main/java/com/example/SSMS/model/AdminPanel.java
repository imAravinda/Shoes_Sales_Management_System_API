package com.example.SSMS.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "AdminPanel")
public class AdminPanel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double totalSales;
    private double totalProfit;
    private String mostSaleItem;
    @Lob
    private byte[] mostSaleItemPic;
    private int mostSaleItemQty;
}
