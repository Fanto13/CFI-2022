package com.ifts.basics.lezione1201.bank;

public class BankAccountUnicredit implements BankAccount {
    public static double annualInterest = 0.02;
    public static double feeDeposit = 1;
    public static double feeWithdraw = 1;

    String IBAN;
    double balance;

    public BankAccountUnicredit(String IBAN, double balance) {
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
        balance -= feeDeposit;
    }

    @Override
    public double withdraw(double amount) {
        balance -= amount;
        balance -= feeDeposit;
        return amount;
    }

    @Override
    public double transfer(BankAccount other, double amount) {
        withdraw(amount);
        other.deposit(amount);
        return amount;
    }

    @Override
    public double addAnnualInterest() {
        double interest = balance * annualInterest;
        balance += interest;
        return interest;
    }

    @Override
    public String toString() {
        return "BankAccountUnicredit{" + "IBAN='" + IBAN + '\'' + ", balance=" + balance + '}';
    }
}
