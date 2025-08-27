import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class LibraryFile {
    private String csvFileName;
    private boolean isFile;

    LibraryFile(String fileName) {
        this.csvFileName = fileName;
        try {
            new File(csvFileName).createNewFile();  // creates file if missing, does nothing if it exists
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveBooks(ArrayList<Book> books) {
        try {
            FileWriter writer = new FileWriter(csvFileName, true);
            for (Book book : books) {
                writer.write(book.getAuthor() + "," +
                              book.getTitle() + "," +
                              book.getPD() + "," +
                              book.getIsbn() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void bookToCsv(Book book) {

    }
}
