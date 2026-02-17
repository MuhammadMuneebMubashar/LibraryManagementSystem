package Classespckg;

import java.io.Serializable;

public class Book implements Serializable {


    private String bookId;

    private String title;

    private String author;

    private boolean isIssued;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId.trim();
        this.title = title.trim();
        this.author = author.trim();
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public boolean setIssued() {
        if (isIssued) {
            return false;
        }
        this.isIssued = true;
        return true;
    }

    public boolean resetIssued() {
        if (!isIssued) {
            return false;
        }
        this.isIssued = false;
        return true;
    }

    public String bookInfo() {
        return String.format("\nBook ID: %s\nTitle: %s\nAuthor: %s\n" +
                "Availability: %s\n", bookId, title, author, ((isIssued)?"No":"Yes"));
    }
}