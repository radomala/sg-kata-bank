package org.sg.bankaccount;

public class BankAccount {

    private double balance;

    public double getBalance() {
        return balance;
    }

    public BankAccount() {
        this.balance = 0.0; // Initialisation du solde à 0
    }

    public void deposit(double amount) {
        balance += (amount > 0) ? amount : throwException("Your deposit is invalid, please enter a value greater than zero");
    }

    private double throwException(String message) {
        throw new IllegalArgumentException(message);
    }


}
