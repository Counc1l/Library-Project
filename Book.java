public class Book {
    private String title;
    private String author;
    private String publicationDate;
    private String isbn;
    private boolean available;

    public Book(String title, String author, String pD, String isbn, boolean avail) {
        this.title = title;
        this.author = author;
        this.publicationDate = pD;
        this.isbn = isbn;
        this.available = avail;
    }

    public void changeAvailability() {
        this.available = !available;
    }

    //Getters
    protected String getTitle() {
        return this.title;
    }

    protected String getAuthor() {
        return this.author;
    }

    protected String getPD() {
        return this.publicationDate;
    }

    protected String getIsbn() {
        return this.isbn;
    }

    protected boolean isAvailable() {
        return this.available;
    }

    protected void printBook() {
        System.out.println("Title: " + this.title +
                            " | Author: " + this.author +
                            " | Status: " + this.available);
    }
}


