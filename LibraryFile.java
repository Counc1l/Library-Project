import java.io.*;
import java.util.ArrayList;

class LibraryFile {
    private final String csvFileName;

    LibraryFile(String fileName) {
        this.csvFileName = fileName;
        try {
            if (new File(csvFileName).createNewFile()) {
                FileWriter writer = new FileWriter(csvFileName);
                writer.write("Title,Author,Year,ISBN,Available");
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected String getCsvFileName() {
        return csvFileName;
    }

    // Saves all books in the Arraylist into CSV for permanent storage
    protected void saveBooks(ArrayList<Book> books) {
        try {
            FileWriter writer = new FileWriter(csvFileName, true);
            for (Book book : books) {
                writer.append(book.getTitle() + "," +
                        book.getAuthor() + "," +
                        book.getPD() + "," +
                        book.getIsbn() + "," +
                        book.isAvailable() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
