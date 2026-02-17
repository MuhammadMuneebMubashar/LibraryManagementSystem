package Classespckg;

import java.io.*;
import java.util.ArrayList;

public class LibraryService{

    private ArrayList<Book> books = new ArrayList<>();
    private static final  String FILENAME = "books.bin";
    private static final  File FILE = new File(FILENAME);

    private static boolean isFileEmpty(){
        try{
            boolean created = FILE.createNewFile();
            if (created){
                return true;
            }return false;
        }catch (Exception e){
            System.out.println("Error loading file");
            return true;
        }
    }
    public LibraryService() {
        if (isFileEmpty()){
            return;
        }
        try(ObjectInputStream br = new ObjectInputStream(new FileInputStream(FILE))){
            Book book;
            while (true){
                book = (Book) br.readObject();
                books.add(book);
            }
        }catch(EOFException e){
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void addBook(Book book){
        if (getBook(book.getBookId()) != null){
            System.out.println("Book already exists");
            return;
        }books.add(book);
        System.out.println("\nBook added\n");
        saveToFile();
    }
    public void removeBook(String  bookId){
        Book book = getBook(bookId);
        if (book != null){
            books.remove(getBook(bookId));
            System.out.println("\nBook removed\n");
            saveToFile();
            return;
        }System.out.println("\nBook not found\n");
    }
    private Book getBook(String bookId){
        for (Book book : books){
            if (book.getBookId().equals(bookId)){
                return book;
            }
        }return  null;
    }
    public void issueBook(String bookId){
        Book book = getBook(bookId);
        if (book != null){
            if (book.setIssued()){
                System.out.println("\nBook issued\n");
                saveToFile();
                return;
            }System.out.println("\nBook already issued\n");
            return;

        }
        System.out.println("\nBook not found\n");
    }
    public void returnBook(String bookId){
        Book book = getBook(bookId);
        if (book != null){
            if (book.resetIssued()){
                System.out.println("\nBook returned\n");
                saveToFile();
                return;
            }System.out.println("\nBook already returned\n");
            return;
        }
        System.out.println("\nBook not found\n");
    }
    public void searchBook(String Find){
        boolean found = false;
        Find = Find.trim().toLowerCase();
        for (Book book : books){
            if (book.getTitle().toLowerCase().contains(Find) ||
            book.getAuthor().toLowerCase().contains(Find) ||
            book.getBookId().toLowerCase().contains(Find)){
                System.out.print(book.bookInfo());
                System.out.println();
                found = true;
            }
        }
        if (! found){
            System.out.println("Book not found !");
        }
    }
    public void showAvailableBooks(){
        boolean found = false;
        for (Book book : books){
            if (! book.isIssued()){
                System.out.print(book.bookInfo());
                System.out.println();
                found = true;
            }
        }
        if (! found){
            System.out.println("No available books found");
        }
    }
    public void showBooks(){
        if (books.isEmpty()){
            System.out.println("\nNo books found\n");
            return;
        }
        for (Book book : books){
            System.out.print(book.bookInfo());
        }
        System.out.println();
    }
    public void countBooks(){
        System.out.println("\nNumber of books found: " + books.size()+ "\n");
    }
    private void saveToFile(){
        try(ObjectOutputStream fw = new ObjectOutputStream(new FileOutputStream(FILE, false))){
            for (Book book : books){
                fw.writeObject(book);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}