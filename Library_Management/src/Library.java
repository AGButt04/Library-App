import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Library extends JFrame implements ActionListener {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Library lib = new Library();
            lib.setVisible(true);
        });
    }

    private JTextField inputField;
    private JTextArea textArea;
    private JButton pressButton;
    private ArrayList<Book> books;
    private ArrayList<Student> students;
    private Librarian librarian;

    private enum State {
        WELCOME,
        LOGIN_MENU,
        STUDENT_MENU,
        LIBRARIAN_MENU,
        BORROW_BOOK,
        RETURN_BOOK,
        PAY_FINE,
        ADD_BOOK,
        REMOVE_BOOK
    }

    private State currentState = State.WELCOME;
    private Student currentStudent = null;

    public Library() {
        setTitle("Library Management System");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);

        inputField = new JTextField();
        pressButton = new JButton("Press");
        pressButton.addActionListener(this);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(pressButton, BorderLayout.EAST);

        add(scroll, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        books = new ArrayList<>();
        students = new ArrayList<>();
        librarian = new Librarian("Libby", "lib123", books);

        // Sample data
        books.add(new Book("Sherlock Holmes", "Arthur Conan Doyle", 10001)); //Love Sherlock
        books.add(new Book("Frankenstein", "Mary Shelby", 10002));
        students.add(new Student("Abdul Ghani Butt", "stu1710174"));
        students.add(new Student("Mosa Butt", "stu1710172"));

        printWelcome();
    }

    private void printWelcome() {
        textArea.setText("Welcome to the Library!\n" +
                "Are you a (S)tudent or (L)ibrarian? Enter 'Q' to quit.");
        currentState = State.LOGIN_MENU;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = inputField.getText().trim();
        inputField.setText("");
        if (input.isEmpty()) return;

        switch (currentState) {
            case LOGIN_MENU -> handleLoginMenu(input);
            case STUDENT_MENU -> handleStudentMenu(input);
            case LIBRARIAN_MENU -> handleLibrarianMenu(input);
            case BORROW_BOOK -> handleBorrowBook(input);
            case RETURN_BOOK -> handleReturnBook(input);
            case PAY_FINE -> handlePayFine(input);
            case ADD_BOOK -> handleAddBook(input);
            case REMOVE_BOOK -> handleRemoveBook(input);
            case WELCOME -> printWelcome();
        }
    }

    private void handleLoginMenu(String input) {
        switch (input.toLowerCase()) {
            case "s" -> {
                textArea.setText("Enter your Student ID:");
                currentState = State.STUDENT_MENU;
            }
            case "l" -> {
                textArea.setText("Enter Librarian ID:");
                currentState = State.LIBRARIAN_MENU;
            }
            case "q" -> System.exit(0);
            default -> textArea.append("\nInvalid option, try again.");
        }
    }

    private void handleStudentMenu(String input) {
        // If we haven't authenticated student yet, check ID
        if (currentStudent == null) {
            for (Student s : students) {
                if (s.getId().equalsIgnoreCase(input)) {
                    currentStudent = s;
                    showStudentOptions();
                    return;
                }
            }
            textArea.append("\nStudent not found, try again.");
        } else {
            switch (input.toLowerCase()) {
                case "b" -> {
                    textArea.setText("Enter book title to borrow:");
                    currentState = State.BORROW_BOOK;
                }
                case "r" -> {
                    textArea.setText("Enter book title to return:");
                    currentState = State.RETURN_BOOK;
                }
                case "p" -> {
                    textArea.setText("Enter amount to pay toward fine (Current fine: " + currentStudent.getFine() + "):");
                    currentState = State.PAY_FINE;
                }
                case "l" -> showStudentLoans();
                case "q" -> {
                    currentStudent = null;
                    printWelcome();
                }
                default -> textArea.append("\nInvalid option, try again.");
            }
        }
    }

    private void showStudentOptions() {
        textArea.setText("Welcome " + currentStudent.getName() + "!\n" +
                "(B)orrow book\n" +
                "(R)eturn book\n" +
                "(P)ay fine\n" +
                "(L)ist borrowed books\n" +
                "(Q)uit");
    }

    private void showStudentLoans() {
        StringBuilder sb = new StringBuilder("Your borrowed books:\n");
        if (currentStudent.getBorrowedBooks().isEmpty()) {
            sb.append("None\n");
        } else {
            for (Book b : currentStudent.getBorrowedBooks()) {
                sb.append(b).append("\n");
            }
        }
        sb.append("Current fine: ").append(currentStudent.getFine()).append("\n");
        sb.append("\nOptions:\n(B)orrow book\n(R)eturn book\n(P)ay fine\n(Q)uit");
        textArea.setText(sb.toString());
    }

    private void handleLibrarianMenu(String input) {
        if (librarian.getId().equalsIgnoreCase(input)) {
            textArea.setText("Welcome Librarian!\n" +
                    "(A)dd book\n" +
                    "(R)emove book\n" +
                    "(V)iew all books\n" +
                    "(Q)uit");
            currentState = State.LIBRARIAN_MENU;
        } else {
            switch (input.toLowerCase()) {
                case "a" -> {
                    textArea.setText("Enter book title to add:");
                    currentState = State.ADD_BOOK;
                }
                case "r" -> {
                    textArea.setText("Enter book title to remove:");
                    currentState = State.REMOVE_BOOK;
                }
                case "v" -> {
                    showAllBooks();
                }
                case "q" -> printWelcome();
                default -> textArea.append("\nInvalid option, try again.");
            }
        }
    }

    private void showAllBooks() {
        StringBuilder sb = new StringBuilder("All Books:\n");
        for (Book b : books) {
            sb.append(b).append("\n");
        }
        sb.append("\n(A)dd book\n(R)emove book\n(V)iew all books\n(Q)uit");
        textArea.setText(sb.toString());
    }

    private void handleBorrowBook(String input) {
        if (currentStudent.getBorrowedBooks().size() >= 3) {
            textArea.setText("Borrow limit reached (3 books). Return a book first.\n");
            showStudentOptions();
            currentState = State.STUDENT_MENU;
            return;
        }
        Book found = null;
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(input) && b.isAvailable()) {
                found = b;
                break;
            }
        }
        if (found != null) {
            found.setAvailable(false);
            currentStudent.getBorrowedBooks().add(found);
            textArea.setText("Book borrowed: " + found + "\n");
        } else {
            textArea.setText("Book not available or does not exist.\n");
        }
        showStudentOptions();
        currentState = State.STUDENT_MENU;
    }

    private void handleReturnBook(String input) {
        Book toReturn = null;
        for (Book b : currentStudent.getBorrowedBooks()) {
            if (b.getTitle().equalsIgnoreCase(input)) {
                toReturn = b;
                break;
            }
        }
        if (toReturn != null) {
            toReturn.setAvailable(true);
            currentStudent.getBorrowedBooks().remove(toReturn);

            // For demo, simulate days borrowed
            int daysBorrowed = 16; // For example
            int lateDays = daysBorrowed - 14;
            if (lateDays > 0) {
                int fineAmount = lateDays * 5;
                currentStudent.addFine(fineAmount);
                textArea.setText("Book returned late. Fine added: " + fineAmount + "\n");
            } else {
                textArea.setText("Book returned on time. Thank you!\n");
            }
        } else {
            textArea.setText("You did not borrow this book.\n");
        }
        showStudentOptions();
        currentState = State.STUDENT_MENU;
    }

    private void handlePayFine(String input) {
        try {
            int amount = Integer.parseInt(input);
            if (amount <= 0) {
                textArea.setText("Enter a positive amount.\n");
            } else if (amount > currentStudent.getFine()) {
                currentStudent.payFine(currentStudent.getFine());
                textArea.setText("Fine fully paid. Thank you!\n");
            } else {
                currentStudent.payFine(amount);
                textArea.setText("Paid " + amount + ". Remaining fine: " + currentStudent.getFine() + "\n");
            }
        } catch (NumberFormatException e) {
            textArea.setText("Invalid number, try again.\n");
        }
        showStudentOptions();
        currentState = State.STUDENT_MENU;
    }

    private void handleAddBook(String input) {
        if (input.isEmpty()) {
            textArea.setText("Title cannot be empty. Enter book title:");
            return;
        }
        String title = input;
        textArea.setText("Enter author name:");
        currentState = State.ADD_BOOK;
        // We'll need to collect author next (2-step input)

        // To keep things simple in this snippet,
        // you could extend this method to a 2-step input or use dialogs.
        // For brevity, you can manually add author in input too separated by comma: "Title, Author"
    }

    private void handleRemoveBook(String input) {
        boolean removed = librarian.removeBook(input);
        if (removed) {
            textArea.setText("Book removed: " + input + "\n");
        } else {
            textArea.setText("Book not found: " + input + "\n");
        }
        showAllBooks();
        currentState = State.LIBRARIAN_MENU;
    }
}