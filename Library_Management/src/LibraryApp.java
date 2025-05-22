import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class LibraryApp {
	
	public static Scanner input = new Scanner(System.in);
	public static ArrayList<Book> books = new ArrayList<>();
	public static ArrayList<User> users = new ArrayList<>();
	public static Library Wlibrary;
	
	public static void main(String[] args) {
		MakeLibrary();
		InputHandler handler = new LibraryInput();
		Wlibrary = new Library(handler);
		print("Welcome to Widener University' memorial library!");
		print("Are you signing in as a (S)tudent or a (L)ibrarian: ");
	}
	
	public static void print(Object obj) {
		Wlibrary.text.append(obj.toString() + "\n");
	}
	
	public static void save() {
		File f = new File("LibrarySave");
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream stream = new ObjectOutputStream(fos);
			stream.writeObject(books);
			stream.writeObject(users);
			stream.close();
		} catch (FileNotFoundException ex) {
			print("File is not found.");
		} catch (IOException e) {
			print("Bummers man!");
			e.printStackTrace();
		}
	}
	
	public static void load() {
		File f = new File("LibrarySave");
		try {
			FileInputStream fos = new FileInputStream(f);
			ObjectInputStream stream = new ObjectInputStream(fos);
			books = (ArrayList) stream.readObject();
			users = (ArrayList) stream.readObject();
			stream.close();
		} catch (FileNotFoundException ex) {
			print("File is not found!");
		} catch (ClassNotFoundException e) {
			print("Object Class not found");
		} catch (IOException exc) {
			print("Bummers, man!");
			exc.printStackTrace();
		}
	}
	
	public static void MakeLibrary() {
		
		books.add(new Book("Sherlock Holmes" , "Arthur Conan Doyle",  "Mystery"));
		books.add(new Book("Harry Potter" , "J.K. Rowling",  "Magic and Fiction"));
		books.add(new Book("Twilight" , "Stephanie Myer",  "Horror Romantic"));
		books.add(new Book("Batman", "Christopher Nolan", "Action"));
		books.add(new Book("Justice League", "Zack Snyder", "Super-Hero"));
		books.add(new Book("Oppenheimer", "Christopher Nolan", "Sci-fi"));
		books.add(new Book("Goodfellas", "Martin Scorcese", "Action-Gangster"));
		books.add(new Book("Once Upon a Time in Hollywood", "Quentin Tarantino", "Mystery"));
		
		users.add(new Student("Ghani Butt", "1710174"));
		users.add(new Student("Mosa Butt", "1710172"));
		users.add(new Student("Zaki Butt", "1710176"));
		users.add(new Student("Gohar Butt", "1710178"));
		users.add(new Student("Hadi Butt", "1710170"));


		users.add(new Librarian("Mark Williams", "4400"));
		users.add(new Librarian("Sir Hadi", "4500"));
	}
	
	
	public static void registerStudent() {
		String stn = JOptionPane.showInputDialog(null, "Enter your name: ");
		String stID = JOptionPane.showInputDialog(null, "Enter your ID: ");
		users.add(new Student(stn,stID));
		print("Congrats, you have successfully registered as a new student.");
	}
	
	public static void registerLibrarian() {
		String usern = JOptionPane.showInputDialog(null, "Enter your name: ");
		String userID = JOptionPane.showInputDialog(null, "Enter your ID: ");
		users.add(new Librarian(usern, userID));
		print("Congrats, you have successfully registered as a new employee.");
	}
	
	public static void searchBook(String name) {
		int count = 0;
		for (Book b : books) {
			if(b.getTitle().equals(name)) {
				count += 1;
				print("Found it!");
				print(b);
			}
		}
		if (count == 0)
			print("There is no such book in our library.");
	}
	
	public static void DisplaySmenu() {
		print("\n1. (A)pply for registeration. " +
				"2. (B)orrow a book. " +
				"3. (R)eturn a book. " +
				"4. (F)ines check. " +
				"5. (P)ay dues. " + 
				"6. Searc(H) a book. " +
				"7. (D)isplay all books. " +
				"8. (M)y borrowed books." +
				"9. (S)ave the data." +
				"10. (L)oad the data." +
				"11. (E)xit. ");
	}
	
	public static void DisplayLmenu() {
		print("\n1. S(I)gn up as new employee. " +
				"2. (F)ines check for students. " +
				"3. (A)dd book to collection. " +
				"4. (R)emove a book. " +
				"5. (D)isplay all books. " +
				"6. (C)heck all transactions. " +
				"8. Bo(O)k finder." +
				"9. Show (N)umber of students. " +
				"10. (S)ave the data." +
				"11. (L)oad the data." +
				"12. (E)xit. ");
	}
	
}