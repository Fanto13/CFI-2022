package com.ifts.moneymanager;

import java.time.LocalDate;

public class Expense {
    LocalDate date;
    String description;
    double amount;

    public Expense(LocalDate date, String description, double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Expense{" + "date=" + date + ", description='" + description + '\'' + ", amount=" + amount + '}';
    }
}
