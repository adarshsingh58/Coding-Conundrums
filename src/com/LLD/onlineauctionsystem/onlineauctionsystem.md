https://github.com/ashishps1/awesome-low-level-design/tree/main/solutions/java/src/onlineauctionsystem

Designing an Online Auction System

In this article, we delve into the object-oriented design and implementation of an Online Auction System using Java.

This system allows for the creation and management of auctions, user participation in bidding, and handling transactions.
Requirements

    The online auction system should allow users to register and log in to their accounts.
    Users should be able to create new auction listings with details such as item name, description, starting price, and auction duration.
    Users should be able to browse and search for auction listings based on various criteria (e.g., item name, category, price range).
    Users should be able to place bids on active auction listings.
    The system should automatically update the current highest bid and notify the bidders accordingly.
    The auction should end when the specified duration is reached, and the highest bidder should be declared the winner.
    The system should handle concurrent access to auction listings and ensure data consistency.
    The system should be extensible to accommodate future enhancements and new features.

Classes, Interfaces and Enumerations

    The User class represents a user in the online auction system, with properties such as id, username, and email.
    The AuctionStatus enum defines the possible states of an auction listing, such as active and closed.
    The AuctionListing class represents an auction listing in the system, with properties like id, item name, description, starting price, duration, seller, current highest bid, and a list of bids.
    The Bid class represents a bid placed by a user on an auction listing, with properties such as id, bidder, amount, and timestamp.
    The AuctionSystem class is the core of the online auction system and follows the Singleton pattern to ensure a single instance of the auction system.
    The AuctionSystem class uses concurrent data structures (ConcurrentHashMap and CopyOnWriteArrayList) to handle concurrent access to auction listings and ensure thread safety.
    The AuctionSystem class provides methods for registering users, creating auction listings, searching auction listings, and placing bids.
    The AuctionSystemDemo class serves as the entry point of the application and demonstrates the usage of the online auction system.
