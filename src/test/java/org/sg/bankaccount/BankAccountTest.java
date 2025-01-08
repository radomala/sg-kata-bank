package org.sg.bankaccount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void testDepositPositiveAmount() {
        BankAccount account = new BankAccount();
        account.deposit(100.0);
        assertEquals(100.0, account.getSolde(), "Balance should be 100 after depositing 100");
    }

    @Test
    public void testDepositZeroAmountThrowsException() {
        BankAccount account = new BankAccount();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> account.deposit(0.0) // Dépôt de 0
        );
        assertEquals("Your deposit is invalid, please enter a value greater than zero", exception.getMessage());
    }

    @Test
    public void testDepositNegativeAmountThrowsException() {
        BankAccount account = new BankAccount();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> account.deposit(-100.0) // Dépôt négatif
        );
        assertEquals("Your deposit is invalid, please enter a value greater than zero", exception.getMessage());
    }

    @Test
    public void testMultipleDeposits() {
        BankAccount account = new BankAccount();
        account.deposit(100.0); // 1er dépôt
        account.deposit(50.0);  // 2em dépôt
        assertEquals(150.0, account.getSolde(), "Balance should be 150 after depositing 100 and 50");
    }

    @Test
    public void testWithdrawValidAmount() {
        BankAccount account = new BankAccount();
        account.deposit(500.0); //First deposit 500 into account
        account.withdraw(100.0); // Retirer 100

        assertEquals(400.0, account.getSolde());
    }

    @Test
    public void testWithdrawMoreThanBalanceThrowsException() {
        BankAccount account = new BankAccount();
        account.deposit(300.0); // Déposer 300
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(1500.0)); // Tentative de retirer 150
    }

    @Test
    public void testWithdrawZeroAmountThrowsException() {
        BankAccount account = new BankAccount();
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0.0));
    }

    @Test
    public void testWithdrawNegativeAmountThrowsException() {
        BankAccount account = new BankAccount();
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-50.0));
    }

    @Test
    public void testBalanceAfterValidWithdrawal() {
        BankAccount account = new BankAccount();
        account.deposit(100.0); // Dépôt initial
        account.withdraw(30.0); // Retrait
        assertEquals(70.0, account.getSolde()); // Vérification du solde restant
    }
}
