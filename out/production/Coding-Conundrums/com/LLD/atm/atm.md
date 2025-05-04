Designing an ATM System
https://github.com/ashishps1/awesome-low-level-design/tree/main/solutions/java/src/atm

Requirements

    The ATM system should support basic operations such as balance inquiry, cash withdrawal, and cash deposit.
    Users should be able to authenticate themselves using a card and a PIN (Personal Identification Number).
    The system should interact with a bank's backend system to validate user accounts and perform transactions.
    The ATM should have a cash dispenser to dispense cash to users.
    The system should handle concurrent access and ensure data consistency.
    The ATM should have a user-friendly interface for users to interact with.

Classes, Interfaces and Enumerations

    The Card class represents an ATM card with a card number and PIN.
    The Account class represents a bank account with an account number and balance. It provides methods to debit and credit the account balance.
    The Transaction class is an abstract base class for different types of transactions, such as withdrawal and deposit. It is extended by WithdrawalTransaction and DepositTransaction classes.
    The BankingService class manages the bank accounts and processes transactions. It uses a thread-safe ConcurrentHashMap to store and retrieve account information.
    The CashDispenser class represents the ATM's cash dispenser and handles the dispensing of cash. It uses synchronization to ensure thread safety when dispensing cash.
    The ATM class serves as the main interface for ATM operations. It interacts with the BankingService and CashDispenser to perform user authentication, balance inquiry, cash withdrawal, and cash deposit.
    The ATMDriver class demonstrates the usage of the ATM system by creating sample accounts and performing ATM operations.
