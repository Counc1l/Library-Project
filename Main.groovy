static void main(String[] args) {
    Library library = new Library();
    Book book = new Book("1", "1", 1, 1, true);
    Book book2 = new Book("1", "1", 1, 1, true);
    library.addBook(book);

    library.borrow(book);
    library.borrow(book2);
    library.borrow(book);
}