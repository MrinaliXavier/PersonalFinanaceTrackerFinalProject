package com.example.personalFinanceTracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long transactionId;

    @NotNull
    private BigDecimal amount;

    private String description;

    @NotNull
    private String transactionDate;



    @Enumerated(EnumType.STRING)
    @NotNull
    private TransactionType transactionType;

    // Establish a relationship with the Category entity
    //@ManyToOne
    //@JoinColumn(name = "category_id", nullable = true)  // Maps the foreign key
    private long categoryId;

    // Constructors, Getters, and Setters
    public Transaction() {}

    public Transaction(long transactionId, BigDecimal amount, String description, String transactionDate, TransactionType transactionType,long categoryId) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.description = description;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.categoryId = categoryId;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {

        this.transactionType = transactionType;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

}
