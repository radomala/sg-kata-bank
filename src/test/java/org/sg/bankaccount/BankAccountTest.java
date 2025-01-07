package org.sg.bankaccount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void testDepositPositiveAmount() {
        BankAccount account = new BankAccount();
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance(), "Balance should be 100 after depositing 100");
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
        assertEquals(150.0, account.getBalance(), "Balance should be 150 after depositing 100 and 50");
    }
}
