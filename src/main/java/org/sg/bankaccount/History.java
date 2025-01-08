package org.sg.bankaccount;

import java.util.Date;


/**
 * Represents a bank account transaction history entry.
 * This record stores information about a specific operation, such as a deposit or withdrawal.
 *
 * @param type        The type of the operation (e.g., deposit or withdrawal).
 * @param amount      The amount of money involved in the operation.
 * @param date        The date and time when the operation occurred.
 * @param balanceAfter  The balance of the account after the operation was performed.
 */
public record History(
        OperationType type,
        double amount,
        Date date,
        double balanceAfter
) {}
