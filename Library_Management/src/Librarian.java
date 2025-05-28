import java.util.ArrayList;
import java.util.Iterator;

public class Librarian extends User {
    private ArrayList<Book> books;

    public Librarian(String name, String id, ArrayList<Book> books) {
        super(name, id);
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBook(String title) {
        Iterator<Book> iter = books.iterator();
        while (iter.hasNext()) {
            Book b = iter.next();
            if (b.getTitle().equalsIgnoreCase(title)) {
                iter.remove();
                return true; // Remove only first found and exit
            }
        }
        return false;
    }
}
