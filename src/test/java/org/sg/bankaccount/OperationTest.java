package org.sg.bankaccount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OperationTest {

    /**
     * Verifies that the getSolde method correctly returns the account balance.
     */
    @Test
    void testGetSolde() {
        Operation operation = new Operation(100.0);
        double balance = operation.getSolde();
        assertEquals(100.0, balance, "The balance should be 100.0");
    }

    /**
     * Verifies that the constructor correctly initializes the account with a given initial balance.
     */
    @Test
    void testConstructorWithInitialBalance() {
        double initialBalance = 200.0;
        Operation operation = new Operation(initialBalance);
        assertEquals(200.0, operation.getSolde(), "The balance should be initialized to 200.0");
    }

    /**
     * Verifies that the default constructor initializes the account balance to 0.0.
     */
    @Test
    void testDefaultConstructor() {
        Operation operation = new Operation();
        assertEquals(0.0, operation.getSolde(), "The balance should be initialized to 0.0");
    }

    /**
     * Verifies that depositing a positive amount correctly updates the account balance.
     */
    @Test
    public void testDepositPositiveAmount() {
        Operation account = new Operation();
        account.deposit(100.0);
        assertEquals(100.0, account.getSolde(), "Balance should be 100 after depositing 100");
    }

    /**
     * Verifies that depositing zero throws an IllegalArgumentException with the appropriate message.
     */
    @Test
    public void testDepositZeroAmountThrowsException() {
        Operation account = new Operation();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> account.deposit(0.0) // Dépôt de 0
        );
        assertEquals("Your deposit is invalid, please enter a value greater than zero", exception.getMessage());
    }

    /**
     * Verifies that depositing a negative amount throws an IllegalArgumentException with the appropriate message.
     */
    @Test
    public void testDepositNegativeAmountThrowsException() {
        Operation account = new Operation();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> account.deposit(-100.0) // Dépôt négatif
        );
        assertEquals("Your deposit is invalid, please enter a value greater than zero", exception.getMessage());
    }

    /**
     * Verifies that multiple deposits correctly update the account balance.
     */
    @Test
    public void testMultipleDeposits() {
        Operation account = new Operation();
        account.deposit(100.0); // 1er dépôt
        account.deposit(50.0);  // 2em dépôt
        assertEquals(150.0, account.getSolde(), "Balance should be 150 after depositing 100 and 50");
    }

    /**
     * Verifies that withdrawing a valid amount correctly updates the account balance.
     */
    @Test
    public void testWithdrawValidAmount() {
        Operation account = new Operation();
        account.deposit(500.0); //First deposit 500 into account
        account.withdraw(100.0); // Retirer 100

        assertEquals(400.0, account.getSolde());
    }

    /**
     * Verifies that attempting to withdraw more than the account balance throws an IllegalArgumentException.
     */
    @Test
    public void testWithdrawMoreThanBalanceThrowsException() {
        Operation account = new Operation();
        account.deposit(300.0); // Déposer 300
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(1500.0)); // Tentative de retirer 150
    }

    /**
     * Verifies that withdrawing zero throws an IllegalArgumentException.
     */
    @Test
    public void testWithdrawZeroAmountThrowsException() {
        Operation account = new Operation();
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0.0));
    }

    /**
     * Verifies that withdrawing a negative amount throws an IllegalArgumentException.
     */
    @Test
    public void testWithdrawNegativeAmountThrowsException() {
        Operation account = new Operation();
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-50.0));
    }

    /**
     * Verifies that the account balance is correctly updated after a valid withdrawal.
     */
    @Test
    public void testBalanceAfterValidWithdrawal() {
        Operation account = new Operation();
        account.deposit(100.0); // Dépôsit initial
        account.withdraw(30.0); // withdraw
        assertEquals(70.0, account.getSolde()); // Vérification du solde restant
    }

    /*
    * Prints a formatted transaction history to the console, including the date, operation type (deposit/withdrawal),
    * amount, and the balance after each transaction.
    */
    @Test
    void testPrintStatement() {
        Operation account = new Operation(1000);
        account.deposit(500);
        account.withdraw(300);

        // Print the statement to the console
        account.printStatement();
    }

}
