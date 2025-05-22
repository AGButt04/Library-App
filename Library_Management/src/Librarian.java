import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Librarian extends User {
	private ArrayList<Book> managedbooks;
	
	public Librarian(String usern, String userID) {
		super(usern, userID);
		managedbooks = LibraryApp.books;
	}
	
	public void addBook() {
		String title = JOptionPane.showInputDialog(null, "Enter the book title : ");
		String author = JOptionPane.showInputDialog(null, "Enter the author's name: ");
		String genre = JOptionPane.showInputDialog(null, "Enter the genre: ");
		managedbooks.add(new Book(title, author, genre));
	}
	
	public void removeBook(String name) {
		for (int i = 0; i < managedbooks.size(); i++) {
			if (managedbooks.get(i).getTitle().equals(name))
				managedbooks.remove(i);
		}
	}
	
	public Book searchBook(String title) {
		for (Book b : managedbooks) {
			if (b.getTitle().equals(title)) {
				LibraryApp.print("Found the book!");
				return b;
			}
		}
		LibraryApp.print("There is no such book.");
		return null;
	}
	
	public String toString() {
		String s = "The Librarian name is " + super.getName() + ". Their ID number is '" + super.getID() + ".'";
		return s;
	}

}
