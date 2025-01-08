Bank account kata

Requirements
- Deposit and Withdrawal
- Account statement (date, amount, balance)
- Statement printing

The expected result is a domain implementation that meets the expressed needs.
Don’t build an entire app, especially no UI, no persistence.

US 1 : 
---------
In order to save money as a bank client I want to make a deposit in my account

Possible cases to test

1) Valid positive deposit:
   - The balance increases correctly.
   - No problems or exceptions.

2) Deposit with zero amount:
   - An exception must be thrown.
   
3) Deposit with a negative amount:
   - An exception must be thrown.

4) Consecutive deposit:
   - Two or more deposits increase the balance correctly.

Implementation of deposit method in BankAccount class

Refactor the code (Refactor)

=========================================================================================
US 2 : In order to retrieve some or all of my savings as a bank client I want to make a
withdrawal from my account

Example test cases:
1) Valid withdrawal (amount less than or equal to the balance).
2) Withdrawal with a negative amount.
3) Withdrawal exceeding the balance.

Implement the withdraw method in the BankAccount class to make the tests pass.

Refactor the code

==========================================================================================

US 3 : In order to check my operations as a bank client I want to see the history (operation,
date, amount, balance) of my operations

1) Created a test to ensure that after performing a deposit or withdrawal, the transaction was correctly added to the history. We also verified that the history contains the correct transaction type, amount, date, and updated balance.

2) Implemented the getTransactionHistory() method and added the necessary logic to the deposit() and withdraw() methods to record each transaction.
Run the test again:

3) After implementing the required functionality, run the tests, and they passed, confirming the correct implementation of the transaction history.

4) Refactored the code where necessary without affecting the tested functionality.

==================================================================================

PRINT STATEMENT

1) Test: Write the test for printStatement().

2) Code: Implement the printStatement() method to print transaction details.

3) Pass: Run the test again, ensuring that the output is printed correctly.

4) Refactor: If necessary, refactor the code to improve readability or efficiency.