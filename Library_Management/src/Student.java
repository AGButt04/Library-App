import java.util.ArrayList;

public class Student extends User {
    private ArrayList<Book> borrowedBooks;
    private int fine;

    public Student(String name, String id) {
        super(name, id);
        this.borrowedBooks = new ArrayList<>();
        this.fine = 0;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public int getFine() {
        return fine;
    }

    // Add to existing fines rather than overwrite
    public void addFine(int amount) {
        if (amount > 0) {
            this.fine += amount;
        }
    }

    // When paying fine, clamp to zero minimum
    public void payFine(int amount) {
        if (amount > 0) {
            fine -= amount;
            if (fine < 0) {
                fine = 0;
            }
        }
    }
}
