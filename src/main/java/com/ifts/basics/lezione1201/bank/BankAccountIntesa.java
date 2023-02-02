package com.ifts.basics.lezione1201.bank;

public class BankAccountIntesa implements BankAccount {
    public static double annualInterest = 0.02;
    public static double feeDeposit = 1;
    public static double feeWithdraw = 1;

    String IBAN;
    double balance;

    public BankAccountIntesa(String IBAN, double balance) {
        this.IBAN = IBAN;
        this.balance = balance;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String getIBAN() {
        return IBAN;
    }

    @Override
    public String getCountry() {
        return IBAN.substring(0,2);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public double withdraw(double amount) {
        double w = Math.min(balance, amount);
        balance -= w;
        return w;
    }

    @Override
    public double transfer(BankAccount other, double amount) {
        double w = 0.0;
        if (getCountry().equals(other.getCountry())) {
            w = withdraw(amount);
            other.deposit(w);
        }
        return w;
    }

    @Override
    public double addAnnualInterest() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "BankAccountIntesa{" + "IBAN='" + IBAN + '\'' + ", balance=" + balance + '}';
    }
}
