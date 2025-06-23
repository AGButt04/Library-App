# 📚 Library Management System

A comprehensive desktop library management application built with Java Swing featuring multi-user authentication, automated fine calculation, and complete book borrowing workflows. Implements advanced object-oriented design patterns with a sophisticated state machine architecture.

## 🎯 What I Built
- **Multi-User System**: Separate authentication and interfaces for Students and Librarians
- **Complete Borrowing Workflow**: Book checkout, return, and availability tracking
- **Automated Fine System**: Late return detection with automatic fine calculation ($5/day after 14 days)
- **Role-Based Access Control**: Different capabilities for Students vs Librarians
- **State Machine Architecture**: Enum-based state management for complex user interactions
- **Business Rule Enforcement**: 3-book borrowing limits and fine payment requirements

## ✨ Key Features

### Student Portal
- 🔐 **Student Authentication**: Secure login with student ID verification
- 📖 **Book Borrowing**: Search and borrow available books (3-book limit)
- 📚 **Return Management**: Return books with automatic late fee calculation
- 💰 **Fine Payment System**: Pay fines with overpayment protection and balance tracking
- 📋 **Borrowed Books Tracking**: View current loans and fine status

### Librarian Portal
- 🔐 **Librarian Authentication**: Secure admin access with librarian credentials
- ➕ **Book Management**: Add new books to library collection
- 🗑️ **Inventory Control**: Remove books from collection with title-based search
- 📊 **Collection Overview**: View all books with availability status

### Core System Features
- ⚡ **Real-Time Updates**: Immediate reflection of all transactions
- 🎯 **State Management**: Sophisticated state machine handling complex workflows
- ⚠️ **Input Validation**: Comprehensive error handling and user feedback
- 💾 **Data Persistence**: Serializable design for future file storage implementation

## 🏗️ System Architecture

```
Library Management System
├── User.java                # Abstract base class for all users
├── Student.java             # Student entity with borrowing and fine management
├── Librarian.java          # Librarian entity with book management capabilities
├── Book.java               # Book entity with availability tracking
└── Library.java            # Main GUI application with state machine
```

### Class Hierarchy
```
User (Serializable)
├── Student (manages borrowed books, fines)
└── Librarian (manages book collection)

Book (Serializable)
└── Availability tracking and metadata
```

## 🔧 Advanced Implementation Details

### State Machine Pattern
- **Enum-based State Management**: Clean state transitions with `State` enum
- **Context-Aware Processing**: Different input handling based on the current state
- **Session Management**: User authentication state persistence

### Business Logic Engine
- **Borrowing Limits**: Enforces 3-book maximum per student
- **Fine Calculation**: Automatic late fee computation (14-day grace period)
- **Availability Tracking**: Real-time book status updates
- **Payment Processing**: Fine payment with balance management

### Object-Oriented Design
- **Inheritance Hierarchy**: Proper abstraction with User base class
- **Composition Patterns**: Students contain borrowed books collections
- **Encapsulation**: Private fields with controlled access methods
- **Polymorphism**: Unified User interface for different user types

## 🚀 Getting Started

```bash
# Clone the repository
git clone https://github.com/AGButt04/Library-App.git

# Navigate to project directory
cd Library-App

# Compile all Java files
javac *.java

# Run the application
java Library
```

### Sample Login Credentials
**Students:**
- ID: `stu1710174` (Abdul Ghani Butt)
- ID: `stu1710172` (Mosa Butt)

**Librarian:**
- ID: `lib123` (Libby)

## 🔧 Technologies & Design Patterns

### Core Technologies
- **Java SE** - Core programming language with modern features
- **Swing Framework** - Desktop GUI with event-driven architecture
- **Collections Framework** - ArrayList for dynamic data management
- **Serialization** - Prepared for data persistence

### Design Patterns
- **State Machine Pattern** - Complex workflow management
- **Strategy Pattern** - Different behaviors for user types
- **Observer Pattern** - GUI updates based on data changes
- **Factory Pattern** - User creation and management

### Advanced Concepts
- **Exception Handling** - NumberFormatException and input validation
- **Lambda Expressions** - Modern Java syntax for event handling
- **Switch Expressions** - Clean conditional logic
- **Enum Usage** - Type-safe state management

## 💡 Technical Highlights

### Sophisticated Business Rules
- **Dynamic Fine Calculation**: Late return detection with configurable fee structure
- **Borrowing Constraints**: Multi-level validation for book checkout limits
- **Payment Processing**: Robust fine payment with overpayment handling
- **Inventory Management**: Real-time availability tracking

### Professional Error Handling
- **Input Validation**: Comprehensive checking for all user inputs
- **State Validation**: Ensures valid state transitions
- **Business Rule Enforcement**: Prevents invalid operations
- **User Feedback**: Clear error messages and operation confirmations

### Memory Management
- **Efficient Collections**: Optimized ArrayList usage for books and students
- **State Cleanup**: Proper session management and resource cleanup
- **Serializable Design**: Prepared for persistent storage implementation

## 📖 Learning Outcomes

This project demonstrates mastery of:
- **Advanced Object-Oriented Programming**: Inheritance, composition, and polymorphism
- **GUI Application Development**: Complex Swing interfaces with state management
- **Business Logic Implementation**: Real-world library management rules
- **Design Pattern Application**: State machine and other enterprise patterns
- **Error Handling and Validation**: Robust input processing and edge case management
- **System Architecture**: Multi-class coordination and data flow design

## 🎮 User Workflows

### Student Workflow
1. **Login**: Enter student ID for authentication
2. **Browse Options**: Choose to borrow, return, pay fines, or view loans
3. **Borrow Books**: Search available books (max 3 concurrent loans)
4. **Return Books**: Return borrowed books with automatic fine calculation
5. **Manage Fines**: Pay outstanding fines with real-time balance updates

### Librarian Workflow
1. **Admin Login**: Enter librarian credentials for system access
2. **Manage Collection**: Add new books to library inventory
3. **Remove Books**: Delete books from collection by title
4. **View Inventory**: Browse all books with availability status

## 🔄 Business Rules

### Borrowing Policy
- **Maximum Loans**: 3 books per student
- **Loan Period**: 14 days standard
- **Late Fees**: $5 per day after due date
- **Fine Restrictions**: Must resolve outstanding fines

### System Constraints
- **Availability Check**: Only available books can be borrowed
- **Duplicate Prevention**: One copy per title per student
- **Session Management**: Secure user authentication required

---
**My first independent OOP project** | [Github Profile](https://github.com/AGButt04) | [LinkedIn](https://www.linkedin.com/in/abdul-ghani-butt-290056338/)

*This project holds special significance as my first venture into independent object-oriented programming, representing the foundation of my software development journey.*
