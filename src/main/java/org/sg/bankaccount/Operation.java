package org.sg.bankaccount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Class representing banking operations such as deposits, withdrawals,
 * and viewing the transaction history.
 */
public class Operation {

    // Current account balance
    private double solde;

    // List to store the history of transactions
    private final List<History> historyTransaction = new ArrayList<>();

    /**
     * Allows a deposit to be made into the account.
     * If the deposit amount is invalid (<= 0), an exception is thrown.
     *
     * @param amount The amount to deposit (must be > 0).
     */
    public void deposit(double amount) {
        solde += (amount > 0) ? amount : throwException("Your deposit is invalid, please enter a value greater than zero");
        // Add the deposit operation to the transaction history
        historyTransaction.add(new History(OperationType.DEPOSIT, amount, new Date(), solde));
    }

    /**
     * Allows a withdrawal to be made from the account.
     * The withdrawal amount must be greater than 0 and less than or equal to the current balance.
     * If the amount is invalid, an exception is thrown.
     *
     * @param amount The amount to withdraw (must be > 0 and <= current balance).
     */
    public void withdraw(double amount) {
        solde = (amount > 0 && amount <= solde) ? solde - amount : throwException ("Invalid withdrawal amount");
        // Add the withdrawal operation to the transaction history
        historyTransaction.add(new History(OperationType.WITHDRAWAL, amount, new Date(), solde));
    }

    /**
     * Retrieves the transaction history as an unmodifiable list.
     * This ensures that the history cannot be modified externally.
     *
     * @return An unmodifiable list of transaction history.
     */
    public List<History> getTransactionHistory() {
        return Collections.unmodifiableList(historyTransaction);
    }

    // Prints the transaction history of the account, displaying the date, type of operation, amount, and balance after each transaction.
    public void printStatement() {
        System.out.println("Transaction History:");
        System.out.println("------------------------------------------------");
        for (History history : historyTransaction) {
            System.out.println("Date: " + history.date());
            System.out.println("Type: " + history.type());
            System.out.println("Amount: " + history.amount());
            System.out.println("Balance After: " + history.soldeAfter());
            System.out.println("------------------------------------------------");
        }
    }

    /**
     * Utility method to throw an exception with a custom message.
     *
     * @param message The message for the exception.
     * @return This method does not return normally as it always throws an exception.
     */
    private double throwException(String message) {
        throw new IllegalArgumentException(message);
    }

    /**
     * Retrieves the current balance of the account.
     *
     * @return The current account balance.
     */
    public double getSolde() {
        return solde;
    }

    /**
     * Constructor to initialize the account with a specific balance.
     *
     * @param solde The initial balance of the account.
     */
    public Operation(double solde) {
        this.solde = solde;
    }

    /**
     * Default constructor (no initial balance specified).
     */
    public Operation() {
    }

}
