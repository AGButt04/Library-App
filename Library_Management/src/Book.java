import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private int isbn;
    private boolean available;

    public Book(String title, String author, int isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + isbn + ")" + (available ? " - Available" : " - Borrowed");
    }
}
