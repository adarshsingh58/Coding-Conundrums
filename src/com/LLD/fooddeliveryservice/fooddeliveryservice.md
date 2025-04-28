https://github.com/ashishps1/awesome-low-level-design/tree/main/solutions/java/src/fooddeliveryservice

Designing an Online Food Delivery Service Like Swiggy
Requirements

    The food delivery service should allow customers to browse restaurants, view menus, and place orders.
    Restaurants should be able to manage their menus, prices, and availability.
    Delivery agents should be able to accept and fulfill orders.
    The system should handle order tracking and status updates.
    The system should support multiple payment methods.
    The system should handle concurrent orders and ensure data consistency.
    The system should be scalable and handle a high volume of orders.
    The system should provide real-time notifications to customers, restaurants, and delivery agents.

Classes, Interfaces and Enumerations

    The Customer class represents a customer who can place orders. It contains customer details such as ID, name, email, and phone number.
    The Restaurant class represents a restaurant that offers menu items. It contains restaurant details such as ID, name, address, and a list of menu items. It provides methods to add and remove menu items.
    The MenuItem class represents an item on a restaurant's menu. It contains details such as ID, name, description, price, and availability status.
    The Order class represents an order placed by a customer. It contains order details such as ID, customer, restaurant, list of order items, status, and assigned delivery agent. It provides methods to add and remove order items, update order status, and assign a delivery agent.
    The OrderItem class represents an item within an order. It contains the selected menu item and the quantity ordered.
    The OrderStatus enum represents the different statuses an order can have, such as PENDING, CONFIRMED, PREPARING, OUT_FOR_DELIVERY, DELIVERED, and CANCELLED.
    The DeliveryAgent class represents a delivery agent who fulfills orders. It contains details such as ID, name, phone number, and availability status.
    The FoodDeliveryService class is the main class that manages the food delivery service. It follows the Singleton pattern to ensure only one instance of the service exists. It provides methods to register customers, restaurants, and delivery agents, retrieve available restaurants and menus, place orders, update order status, cancel orders, and assign delivery agents to orders. It also handles notifications to customers, restaurants, and delivery agents.
