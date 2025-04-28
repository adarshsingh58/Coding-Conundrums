https://github.com/ashishps1/awesome-low-level-design/tree/main/solutions/java/src/elevatorsystem

Designing an Elevator System
Requirements

    The elevator system should consist of multiple elevators serving multiple floors.
    Each elevator should have a capacity limit and should not exceed it.
    Users should be able to request an elevator from any floor and select a destination floor.
    The elevator system should efficiently handle user requests and optimize the movement of elevators to minimize waiting time.
    The system should prioritize requests based on the direction of travel and the proximity of the elevators to the requested floor.
    The elevators should be able to handle multiple requests concurrently and process them in an optimal order.
    The system should ensure thread safety and prevent race conditions when multiple threads interact with the elevators.

Classes, Interfaces and Enumerations

    The Direction enum represents the possible directions of elevator movement (UP or DOWN).
    The Request class represents a user request for an elevator, containing the source floor and destination floor.
    The Elevator class represents an individual elevator in the system. It has a capacity limit and maintains a list of 4. requests. The elevator processes requests concurrently and moves between floors based on the requests.
    The ElevatorController class manages multiple elevators and handles user requests. It finds the optimal elevator to serve a request based on the proximity of the elevators to the requested floor.
    The ElevatorSystem class is the entry point of the application and demonstrates the usage of the elevator system.
