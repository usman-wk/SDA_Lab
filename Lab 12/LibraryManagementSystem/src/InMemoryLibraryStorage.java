import java.util.ArrayList;
import java.util.List;

public class InMemoryLibraryStorage implements LibraryStorage {
    private final List<Book> books = new ArrayList<>();

    @Override
    public synchronized void save(Book book) {
        books.add(book);
    }

    @Override
    public synchronized List<Book> getAll() {
        return new ArrayList<>(books);
    }

    @Override
    public synchronized boolean deleteByTitle(String title) {
        return books.removeIf(b -> b.getTitle().equalsIgnoreCase(title));
    }
}
