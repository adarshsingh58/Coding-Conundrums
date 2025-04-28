Designing a Parking Lot System
https://github.com/ashishps1/awesome-low-level-design/tree/main/solutions/java/src/parkinglot

Requirements

    The parking lot should have multiple levels, each level with a certain number of parking spots.
    The parking lot should support different types of vehicles, such as cars, motorcycles, and trucks.
    Each parking spot should be able to accommodate a specific type of vehicle.
    The system should assign a parking spot to a vehicle upon entry and release it when the vehicle exits.
    The system should track the availability of parking spots and provide real-time information to customers.
    The system should handle multiple entry and exit points and support concurrent access.

Classes, Interfaces and Enumerations

    The ParkingLot class follows the Singleton pattern to ensure only one instance of the parking lot exists. It maintains a list of levels and provides methods to park and unpark vehicles.
    The Level class represents a level in the parking lot and contains a list of parking spots. It handles parking and unparking of vehicles within the level.
    The ParkingSpot class represents an individual parking spot and tracks the availability and the parked vehicle.
    The Vehicle class is an abstract base class for different types of vehicles. It is extended by Car, Motorcycle, and Truck classes.
    The VehicleType enum defines the different types of vehicles supported by the parking lot.
    Multi-threading is achieved through the use of synchronized keyword on critical sections to ensure thread safety.
    The Main class demonstrates the usage of the parking lot system.

Design Patterns Used:

    Singleton Pattern: Ensures only one instance of the ParkingLot class.
    Factory Pattern (optional extension): Could be used for creating vehicles based on input.
    Observer Pattern (optional extension): Could notify customers about available spots.
