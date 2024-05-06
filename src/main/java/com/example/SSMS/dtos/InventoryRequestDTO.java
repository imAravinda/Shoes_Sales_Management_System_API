package com.example.SSMS.dtos;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class InventoryRequestDTO {
    private String itemCode;
    private String itemDesc;
    private MultipartFile itemPic;
    private String category;
    private int size;
    private String supplierCode;
    private String supplierName;
    private double unitPriceSale;
    private double unitPriceBuy;
    private String status;
}
