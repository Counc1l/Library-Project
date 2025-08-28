import java.io.*;
import java.util.ArrayList;

class LibraryFile {
    private String csvFileName;

    LibraryFile(String fileName) {
        this.csvFileName = fileName;
        try {
            new File(csvFileName).createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected String getCsvFileName() {
        return csvFileName;
    }

    protected void saveBooks(ArrayList<Book> books) {
        for (Book book : books) {
            bookToCsv(book);
        }
    }

    private void bookToCsv(Book book) {
        try {
            FileWriter writer = new FileWriter(csvFileName, true);
            writer.append(book.getTitle() + "," +
                    book.getAuthor() + "," +
                    book.getPD() + "," +
                    book.getIsbn() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
