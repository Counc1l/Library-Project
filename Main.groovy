static void main(String[] args) {
    Library library = new Library();
    Book book = new Book("a","b",1,1,true);

    library.addBook(book);
    library.saveBooks();
}