Library Management System (Java Swing)
Overview
This is a simple Library Management System implemented in Java using Swing for the graphical user interface (GUI). The application allows users to:

Log in with a username and password.
View available books.
Borrow books.
Return books.
See the list of currently borrowed books.
Log out.

The program maintains a simple state machine to handle user inputs and interactions via a GUI with a text input field and buttons.

Features
User Authentication: Simple username/password login.

Book Management: View, borrow, and return books.

GUI Interface: Uses Java Swing components (JFrame, JTextArea, JTextField, JButton) for interactive user experience.

State-Based Input Handling: Different actions based on the current menu or prompt.

Real-Time Feedback: Displays messages and updates the book list dynamically.

How to Run
Ensure you have JDK installed (Java 8 or later).

Compile the source code:
javac Library.java

Run the application:
java Library

The login window will appear. Use the default credentials:
Username: user
Password: pass
Follow on-screen prompts to navigate the menus and manage books.

Code Structure:
Library.java
The main class containing the GUI setup, event handling, and application logic.
