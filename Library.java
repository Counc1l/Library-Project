import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> list;

    public Library(){
        this.list = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        this.list.add(book);
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
}
