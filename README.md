Bank account kata

Requirements
- Deposit and Withdrawal
- Account statement (date, amount, balance)
- Statement printing

The expected result is a domain implementation that meets the expressed needs.
Don’t build an entire app, especially no UI, no persistence.

User Stories
US 1:
In order to save money as a bank client I want to make a deposit in my account
US 2:
In order to retrieve some or all of my savings as a bank client I want to make a
withdrawal from my account
US 3:
In order to check my operations as a bank client I want to see the history (operation,
date, amount, balance) of my operations

Constraint
No framework (only test framework and maven are allowed).

Usage
mvn test

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

===================================================================
US 2 : In order to retrieve some or all of my savings as a bank client I want to make a
withdrawal from my account

Example test cases:
1) Valid withdrawal (amount less than or equal to the balance).
2) Withdrawal with a negative amount (should fail).
3) Withdrawal exceeding the balance (should fail).

Implement the withdraw method in the BankAccount class to make the tests pass.

Refactor the code
