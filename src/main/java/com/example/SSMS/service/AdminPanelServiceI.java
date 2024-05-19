package com.example.SSMS.service;

import com.example.SSMS.model.AdminPanel;

import java.util.Date;

public interface AdminPanelServiceI {
    AdminPanel getSalesSummary(Date date);
}
