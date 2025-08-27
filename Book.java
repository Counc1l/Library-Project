public class Book {
    private String title;
    private String author;
    private int publicationDate;
    private int isbn;
    private boolean available;

    public Book(String title, String author, int pD, int isbn, boolean avail) {
        this.title = title;
        this.author = author;
        this.publicationDate = pD;
        this.isbn = isbn;
        this.available = avail;
    }

    public void changeAvailability() {
        this.available = !available;
    }

    protected boolean isAvailable() {
        return available;
    }

    protected String getTitle() {
        return this.title;
    }

    protected String getAuthor() {
        return this.author;
    }

    protected int getPD() {
        return this.publicationDate;
    }

    protected int isbn() {
        return this.isbn;
    }
}


