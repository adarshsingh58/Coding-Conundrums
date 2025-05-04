Designing a Vending Machine
https://github.com/ashishps1/awesome-low-level-design/tree/main/solutions/java/src/vendingmachine

Requirements

    The vending machine should support multiple products with different prices and quantities.
    The machine should accept coins and notes of different denominations.
    The machine should dispense the selected product and return change if necessary.
    The machine should keep track of the available products and their quantities.
    The machine should handle multiple transactions concurrently and ensure data consistency.
    The machine should provide an interface for restocking products and collecting money.
    The machine should handle exceptional scenarios, such as insufficient funds or out-of-stock products.

Classes, Interfaces and Enumerations

    The Product class represents a product in the vending machine, with properties such as name and price.
    The Coin and Note enums represent the different denominations of coins and notes accepted by the vending machine.
    The Inventory class manages the available products and their quantities in the vending machine. It uses a concurrent hash map to ensure thread safety.
    The VendingMachineState interface defines the behavior of the vending machine in different states, such as idle, ready, and dispense.
    The IdleState, ReadyState, and DispenseState classes implement the VendingMachineState interface and define the specific behaviors for each state.
    The VendingMachine class is the main class that represents the vending machine. It follows the Singleton pattern to ensure only one instance of the vending machine exists.
    The VendingMachine class maintains the current state, selected product, total payment, and provides methods for state transitions and payment handling.
    The VendingMachineDemo class demonstrates the usage of the vending machine by adding products to the inventory, selecting products, inserting coins and notes, dispensing products, and returning change.
