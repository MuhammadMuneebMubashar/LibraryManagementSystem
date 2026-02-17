import Classespckg.*;

import java.util.Scanner;

public class LibraryMangementSystem {

    private static LibraryService lib = new LibraryService();
    private static Scanner sc = new Scanner(System.in);

    public static void addBook(){
        System.out.print("Enter Book ID: ");
        String bookId = sc.nextLine();
        System.out.print("Enter Book Name: ");
        String bookName = sc.nextLine();
        System.out.print("Enter Book Author: ");
        String bookAuthor = sc.nextLine();
        Book book = new Book(bookId, bookName, bookAuthor);
        lib.addBook(book);
    }
    public static void removeBook(){
        System.out.print("Enter Book ID: ");
        String bookId = sc.nextLine();
        lib.removeBook(bookId);
    }
    public static void listBooks(){
        System.out.println("Books List");
        lib.showBooks();
    }
    public static void countBooks(){
        lib.countBooks();
    }
    public static void close(){
        System.out.println("Exiting ... ");
        sc.close();
    }
    public static void issueBook(){
        System.out.print("Enter Book ID: ");
        String bookId = sc.nextLine();
        lib.issueBook(bookId);
    }
    public static void returnBook(){
        System.out.print("Enter Book ID: ");
        String bookId = sc.nextLine();
        lib.returnBook(bookId);
    }
    public static void searchBook(){
        System.out.print("Enter Keywords: ");
        String search = sc.nextLine();
        lib.searchBook(search);
    }
    public static void showAvailableBooks(){
        lib.showAvailableBooks();
    }
    public static void menu(){
        while(true){
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. List Books");
            System.out.println("4. Count Books");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Search Book");
            System.out.println("8. Show Available Books");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    listBooks();
                    break;
                case 4:
                    countBooks();
                    break;
                case 5:
                    issueBook();
                    break;
                case 6 :
                    returnBook();
                    break;
                case 7:
                    searchBook();
                    break;
                case 8:
                    showAvailableBooks();
                    break;
                case 9:
                    close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }
    public static void main (String[] args){
        menu();
    }
}