package com.example.SSMS.service.impl;

import com.example.SSMS.dtos.SalesRequestDTO;
import com.example.SSMS.model.Inventory;
import com.example.SSMS.model.OrderItems;
import com.example.SSMS.model.Sale;
import com.example.SSMS.repository.CustomerDAO;
import com.example.SSMS.repository.InventoryDAO;
import com.example.SSMS.repository.OrderItemsDAO;
import com.example.SSMS.repository.SalesDAO;
import com.example.SSMS.service.SaleServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class SaleService implements SaleServiceI {

    @Autowired
    SalesDAO salesDAO;
    @Autowired
    InventoryDAO inventoryDAO;
    @Autowired
    OrderItemsDAO itemsDAO;
    @Autowired
    CustomerDAO customerDAO;

    @Override
    @Transactional
    public Sale createOrder(SalesRequestDTO saleRequest) {
        Sale sale = new Sale();
        double totalBillAmount = 0;
        sale.setOrderNo(generateOrderNumber());
        sale.setCashierName(saleRequest.getCashierName());
        sale.setCustomerName(saleRequest.getCustomerName());
        sale.setPaymentMethod(saleRequest.getPaymentMethod());
        sale.setPurchaseDate(new Date());
        if (saleRequest.isHasLoyalityCard()) {
            sale.setAddedPoints(saleRequest.getAddedPoints());
            sale.setCustomer(saleRequest.getCustomerCode());
        }
        ArrayList<OrderItems> items = new ArrayList<>();
        for (OrderItems item : saleRequest.getItems()) {
            Inventory inventory = inventoryDAO.findByItemCode(item.getItemCode());
            if (inventory != null) {
                OrderItems newItem = new OrderItems();
                newItem.setItemCode(item.getItemCode());
                newItem.setItemDesc(inventory.getItemDesc());
                newItem.setUnitPrice(inventory.getUnitPriceSale());
                newItem.setSize(item.getSize());
                newItem.setQty(item.getQty());
                double totalPrice = newItem.getQty() * newItem.getUnitPrice();
                newItem.setTotalPriceOfEachItem(totalPrice);
                newItem.setSale(sale);
                totalBillAmount += totalPrice;
                items.add(newItem);
            } else {
                throw new RuntimeException("Item is Not Found");
            }
        }
        sale.setTotalPrice(totalBillAmount);
        sale.setItems(items);
        sale = salesDAO.save(sale);
        for (OrderItems item : items) {
            itemsDAO.save(item);
        }
        return sale;
    }

    @Override
    public List<Sale> getAllSales() {
        return salesDAO.findAll();
    }

    @Override
    public Sale getSaleByOrderNo(String orderNo) {
        return salesDAO.findByOrderNo(orderNo);
    }

    @Override
    public Sale updateSaleByOrderNo(String orderNo, SalesRequestDTO updateSaleRequest) {
        return null;
    }

    private String generateOrderNumber() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        // You can use a random number or sequence for the order part
        int orderPart = new Random().nextInt(10000); // Random number between 0 and 9999
        return "ORD" + timestamp + orderPart;
    }

}
