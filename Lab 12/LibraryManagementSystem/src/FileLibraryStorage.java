import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileLibraryStorage implements LibraryStorage {
    private final Path file;

    public FileLibraryStorage(String filename) throws IOException {
        this.file = Paths.get(filename);
        if (Files.notExists(file)) Files.createFile(file);
    }

    @Override
    public synchronized void save(Book book) {
        try (BufferedWriter bw = Files.newBufferedWriter(file, StandardOpenOption.APPEND)) {
            bw.write(book.getTitle() + "|" + book.getAuthor());
            bw.newLine();
        } catch (IOException e) { throw new RuntimeException(e); }
    }

    @Override
    public synchronized List<Book> getAll() {
        List<Book> list = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(file)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|", 2);
                if (parts.length == 2) list.add(new Book(parts[0], parts[1]));
            }
        } catch (IOException e) { throw new RuntimeException(e); }
        return list;
    }

    @Override
    public synchronized boolean deleteByTitle(String title) {
        List<Book> remaining = new ArrayList<>();
        boolean removed = false;
        for (Book b : getAll()) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                removed = true;
            } else {
                remaining.add(b);
            }
        }
        if (removed) {
            try (BufferedWriter bw = Files.newBufferedWriter(file, StandardOpenOption.TRUNCATE_EXISTING)) {
                for (Book b : remaining) {
                    bw.write(b.getTitle() + "|" + b.getAuthor());
                    bw.newLine();
                }
            } catch (IOException e) { throw new RuntimeException(e); }
        }
        return removed;
    }
}
