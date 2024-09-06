package com.example.personalFinanceTracker.service;

import com.example.personalFinanceTracker.Repo.DashboardRepo;
import com.example.personalFinanceTracker.entity.Transaction;
import com.example.personalFinanceTracker.entity.Category;
import com.example.personalFinanceTracker.entity.CategoryType;
import com.example.personalFinanceTracker.Repo.TransactionRepo;
import com.example.personalFinanceTracker.Repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.personalFinanceTracker.entity.Dashboard;
import com.example.personalFinanceTracker.entity.TransactionType;


@Service
public class TransactionService {

    @Autowired
    private TransactionRepo transactionRepository;

    @Autowired
    private CategoryRepo categoryRepository;

    public List<Transaction> getAllTransactionsWithCategoryInfo() {
        // Since the Transaction entity now includes a reference to Category,
        // it will fetch category details with each transaction.
        return transactionRepository.findAll();
    }

    public List<Transaction> getAllTransactions() {

        return transactionRepository.findAll();
    }


    public Optional<Transaction> getTransactionById(Long transactionId) {
        return transactionRepository.findById(transactionId);
    }

    public Transaction addTransaction(Transaction transaction) {
        //transaction.getCategory
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(Long transactionId, Transaction transactionDetails) {
        return transactionRepository.findById(transactionId)
                .map(transaction -> {
                    transaction.setAmount(transactionDetails.getAmount());
                    transaction.setDescription(transactionDetails.getDescription());
                    transaction.setTransactionDate(transactionDetails.getTransactionDate());
                    transaction.setTransactionType(transactionDetails.getTransactionType());
                    transaction.setCategoryId(transactionDetails.getCategoryId());
                    return transactionRepository.save(transaction);
                })
                .orElse(null);
    }

    public boolean deleteTransaction(Long transactionId) {
        return transactionRepository.findById(transactionId)
                .map(transaction -> {
                    transactionRepository.delete(transaction);
                    return true;
                })
                .orElse(false);
    }

    // Additional service method to fetch all category types
    public List<CategoryType> getAllCategoryTypes() {
        return categoryRepository.findAll()
                .stream()
                .map(Category::getCategoryType)
                .distinct()
                .collect(Collectors.toList());
    }


    public Dashboard getDashboardData() {
        List<Transaction> transactions = transactionRepository.findAll();

        BigDecimal totalIncome = transactions.stream()
                .filter(t -> t.getTransactionType() == TransactionType.INCOME)
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalExpenses = transactions.stream()
                .filter(t -> t.getTransactionType() == TransactionType.EXPENSE)
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal balance = totalIncome.subtract(totalExpenses);

        return new Dashboard(0L, totalIncome, totalExpenses, balance);
    }

}
