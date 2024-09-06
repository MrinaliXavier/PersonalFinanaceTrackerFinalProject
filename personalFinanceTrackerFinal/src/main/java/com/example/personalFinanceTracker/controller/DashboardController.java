package com.example.personalFinanceTracker.controller;


import com.example.personalFinanceTracker.entity.Dashboard;
import com.example.personalFinanceTracker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public String getDashboard(Model model) {
        Dashboard dashboard = transactionService.getDashboardData();
        model.addAttribute("dashboard", dashboard);


        return "dashboard";  // Corresponds to the Thymeleaf template name (dashboard.html)
    }
}

