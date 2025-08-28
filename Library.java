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

    public void addBook(Book book) {
        this.list.add(book);
    }

    public void saveBooks() throws IOException {
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

    private void loadBooks() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(libraryFile.getCsvFileName()));
            String[] split;
            while (reader.ready()) {
                split = reader.readLine().split(",");
                Book book = new Book(split[0], split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), true);
                list.add(book);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
