package com.example.SSMS.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String orderNo;
    private String customerName;
    private double totalPrice;
    private Date purchaseDate;
    private String paymentMethod;
    private double addedPoints;
    private String cashierName;
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("sale")
    List<OrderItems> items;
    @ManyToOne
    @JoinColumn(name = "customer_code", referencedColumnName = "customerCode")
    private Customer customer;
}