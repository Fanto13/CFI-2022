package com.ifts.basics.lezione1201.bank;

public interface BankAccount {
    String getIBAN();
    String getCountry();
    void deposit(double amount);
    double withdraw(double amount);
    double transfer(BankAccount other, double amount);
    double addAnnualInterest();
}
