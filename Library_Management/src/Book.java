import java.io.Serializable;
import java.util.Random;

public class Book implements Serializable{
	private int isbn;
	private String title;
	private String author;
	private String genre;
	private boolean isAvailable;
	
	public Book(String t, String a, String gen) {
		Random rand = new Random();
		isbn = rand.nextInt(100000);
		title = t;
		author = a;
		genre = gen;
		isAvailable = true;
	}
	
	public int getISBN() {
		return isbn;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public boolean getAvailable() {
		return isAvailable;
	}
	
	public void setISBN(int num) {
		isbn = num;
	}
	
	public void setTitle(String tl) {
		title = tl;
	}
	
	public void setAuthor(String auth) {
		author = auth;
	}
	
	public void setGenre(String G) {
		genre = G;
	}
	
	public void setAvailable(boolean check) {
		isAvailable = check;
	}
	
	public String toString() {
		String s = "The book '"+ title + "'";
		s += "is written by " + author +" in " + genre + " genre.";
		s += "Its ISBN is " + isbn + ".";
		s += "It is currently " + (isAvailable? "available." : "Unavailable.");
		return s;
	}
}
