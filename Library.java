import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> list;
    private LibraryFile libraryFile;

    public Library(){
        this.list = new ArrayList<Book>();
        this.libraryFile = new LibraryFile("books.csv");
        loadBooks();
    }

    private void loadBooks() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(libraryFile.getCsvFileName()));
            reader.readLine(); //Skips Header Row - WIP
            String[] split;
            while (reader.ready()) {
                split = reader.readLine().split(",");
                Book book = new Book(split[0], split[1], split[2], split[3], Boolean.parseBoolean(split[4]));
                list.add(book);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void addBook(Book book) {
        this.list.add(book);
    }

    public void saveBooks() {
        this.libraryFile.saveBooks(this.list);
    }

    public void search(Book book) {
        if (list.contains(book)) System.out.println("We have that book!");
        else System.out.println("That book is not in our system.");
    }

    public void borrow(Book book) {
        if (list.contains(book) && book.isAvailable()) {
            book.changeAvailability();
            System.out.println("Book is borrowed!");
        }
        else {
            System.out.println("That book is currently unavailable.");
        }
    }

    public void displayBooks() {
        for (Book book : list) {
            book.printBook();
        }
    }
}
