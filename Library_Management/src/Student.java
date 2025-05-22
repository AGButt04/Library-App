import java.util.ArrayList;

public class Student extends User {
	
	public ArrayList<Book> borrowedBooks;
	private double fine;
	
	public Student(String usern, String userID) {
		super(usern, userID);
		borrowedBooks = new ArrayList<Book>();
		fine = 0;
	}
	
	public boolean borrowBook(Book book) {
		if(book.getAvailable()) {
			if (borrowedBooks.size() <= 3) {
				borrowedBooks.add(book);
				book.setAvailable(false);
				return true;
			} else {
				LibraryApp.print("You have reached the max limit of 3 books.");
				return false;
			}
		} else {
			LibraryApp.print("The book is currently unavailable.");
			return false;
		}
	}
	
	public void returnBook(Book book1) {
		borrowedBooks.remove(book1); 
		book1.setAvailable(true);
	}
	
	public void setFine(double amount) {
		fine = amount;
	}
	public double getFine() {
		return fine;
	}
	
	public void payFine(double amount) {
		double ch = this.getFine();
		if (ch > 0) {
			fine -= amount;
		} else {
			LibraryApp.print("You do not have any pending fines.");
		}
	}
	
	public ArrayList<Book> getBorrowedB() {
		return borrowedBooks;
	}
	
	public void printBorrowedbooks() {
		for (Book b : borrowedBooks) {
			LibraryApp.print(b);
		}
	}
	
	public String toString() {
		String s = "Student's name is " + super.getName() + " and his ID is " + super.getID();
		s += ". His fine is $" + fine + ", and his borrowed books are: " + borrowedBooks;
		return s;
	}
	
}
