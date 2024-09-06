package com.example.personalFinanceTracker.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table
public class Dashboard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long personId;

    private BigDecimal totalExpenses;

    private BigDecimal totalIncome;

    private BigDecimal balance;

    public Dashboard(long personId, BigDecimal totalExpenses, BigDecimal totalIncome, BigDecimal balance) {
        this.personId = personId;
        this.totalExpenses = totalExpenses;
        this.totalIncome = totalIncome;
        this.balance = balance;
    }
    public Dashboard() {

    }


    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public BigDecimal getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(BigDecimal totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }





}
