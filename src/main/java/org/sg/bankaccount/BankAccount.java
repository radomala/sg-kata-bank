package org.sg.bankaccount;

public class BankAccount {

    private double solde = 0.0;

    public double getSolde() {
        return solde;
    }

    public void deposit(double amount) {
        solde += (amount > 0) ? amount : throwException("Your deposit is invalid, please enter a value greater than zero");
    }

    public void withdraw(double amount) {
        solde = (amount > 0 && amount <= solde) ? solde - amount : throwException ("Invalid withdrawal amount");
    }

    private double throwException(String message) {
        throw new IllegalArgumentException(message);
    }

}
