package com.example.personalFinanceTracker.controller;

import com.example.personalFinanceTracker.entity.Transaction;
import com.example.personalFinanceTracker.service.CategoryService;
import com.example.personalFinanceTracker.service.TransactionService;
import com.example.personalFinanceTracker.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String getAllTransactions(Model model) {
        List<Transaction> transactions = transactionService.getAllTransactionsWithCategoryInfo();
        List<Category> categories = categoryService.getAllCategories(); // Fetch categories

        model.addAttribute("transactions", transactions);
        model.addAttribute("categories", categories);

        return "transactions";  // This is your Thymeleaf template


    }


    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Transaction> getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }

    @PostMapping
    @ResponseBody
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        System.out.println(transaction);
        return transactionService.addTransaction(transaction);

    }

    @PutMapping("/{id}")
    @ResponseBody
    public Transaction updateTransaction(@PathVariable Long id, @RequestBody Transaction transactionDetails) {
        return transactionService.updateTransaction(id, transactionDetails);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public boolean deleteTransaction(@PathVariable Long id) {

        return transactionService.deleteTransaction(id);
    }
}
