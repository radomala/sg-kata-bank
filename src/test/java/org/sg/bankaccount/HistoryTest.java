package org.sg.bankaccount;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HistoryTest {

    /**
     * Test the transaction history functionality.
     * Verifies that deposit and withdrawal operations are correctly recorded
     * with their respective details (type, amount, date, and balance after transaction).
     */
    @Test
    void testTransactionHistoryWithRecord() {
        Operation account = new Operation(1000);
        account.deposit(500);
        account.withdraw(300);

        List<History> history = account.getTransactionHistory();

        assertEquals(2, history.size());

        History depositTransaction = history.get(0);
        assertEquals(OperationType.DEPOSIT, depositTransaction.type());
        assertEquals(500, depositTransaction.amount());
        assertNotNull(depositTransaction.date());
        assertEquals(1500, depositTransaction.soldeAfter());

        History withdrawalTransaction = history.get(1);
        assertEquals(OperationType.WITHDRAWAL, withdrawalTransaction.type());
        assertEquals(300, withdrawalTransaction.amount());
        assertNotNull(withdrawalTransaction.date());
        assertEquals(1200, withdrawalTransaction.soldeAfter());
    }
}
