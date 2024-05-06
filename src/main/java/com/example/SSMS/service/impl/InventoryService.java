package com.example.SSMS.service.impl;

import com.example.SSMS.dtos.InventoryRequestDTO;
import com.example.SSMS.model.Inventory;
import com.example.SSMS.repository.InventoryDAO;
import com.example.SSMS.service.InventoryServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class InventoryService implements InventoryServiceI {

    @Autowired
    InventoryDAO inventoryDAO;

    @Override
    public Inventory addInventories(InventoryRequestDTO request) {
        Inventory inventory = new Inventory();
        inventory.setItemCode(request.getItemCode());
        inventory.setItemDesc(request.getItemDesc());
        String image = convertToBase64(request.getItemPic());
        System.out.println(image);
        inventory.setItemPic(image);
        inventory.setCategory(request.getCategory());
        inventory.setSize(request.getSize());
        inventory.setSupplierCode(request.getSupplierCode());
        inventory.setSupplierName(request.getSupplierName());
        inventory.setUnitPriceBuy(request.getUnitPriceBuy());
        inventory.setUnitPriceSale(request.getUnitPriceSale());
        double expectedProfit = request.getUnitPriceSale() - request.getUnitPriceBuy();
        inventory.setExpectedProfit(expectedProfit);
        double profitMargin = (expectedProfit * 100)/ request.getUnitPriceBuy();
        inventory.setProfitMargin(profitMargin);
        inventory.setStatus(request.getStatus());
        return inventoryDAO.save(inventory);
    }

    @Override
    public List<Inventory> getInventories() {
        return inventoryDAO.findAll();
    }

    @Override
    public Inventory getInventoryByItemCode(String itemCode) {
        return inventoryDAO.findByItemCode(itemCode);
    }

    @Override
    public Inventory updateInvantory(String itemCode,Inventory updatedInvetory) {
        updatedInvetory.setItemCode(itemCode);
        return inventoryDAO.save(updatedInvetory);
    }

    @Override
    public void removeInventoryByItemCode(String itemCode) {
        inventoryDAO.deleteByItemCode(itemCode);
    }

    private String convertToBase64(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            return java.util.Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            return null;
        }
    }
}
