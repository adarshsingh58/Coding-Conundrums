https://github.com/ashishps1/awesome-low-level-design/tree/main/solutions/java/src/courseregistrationsystem

Designing a University Course Registration System
Requirements

    The course registration system should allow students to register for courses and view their registered courses.
    Each course should have a course code, name, instructor, and maximum enrollment capacity.
    Students should be able to search for courses based on course code or name.
    The system should prevent students from registering for courses that have reached their maximum enrollment capacity.
    The system should handle concurrent registration requests from multiple students.
    The system should ensure data consistency and prevent race conditions.
    The system should be extensible to accommodate future enhancements and new features.

Classes, Interfaces and Enumerations

    The Student class represents a student in the course registration system, with properties such as ID, name, email, and a list of registered courses.
    The Course class represents a course offered in the system, with properties such as code, name, instructor, maximum capacity, and the number of enrolled students.
    The Registration class represents a registration record, associating a student with a course and capturing the registration timestamp.
    The CourseRegistrationSystem class is the main class that manages the course registration system. It follows the Singleton pattern to ensure only one instance of the system exists.
    The CourseRegistrationSystem class provides methods for adding courses and students, searching for courses, registering students for courses, and retrieving registered courses for a student.
    Multi-threading is implemented using concurrent data structures (ConcurrentHashMap and CopyOnWriteArrayList) to handle concurrent access to shared data, such as courses and registrations.
    The registerCourse method is synchronized to ensure thread safety when multiple students are registering for courses simultaneously.
    The notifyObservers method is a placeholder for notifying observers (e.g., UI components) about updates to course enrollment.
    The CourseRegistrationDemo class demonstrates the usage of the course registration system by creating courses and students, searching for courses, registering students for courses, and retrieving registered courses for a student.
