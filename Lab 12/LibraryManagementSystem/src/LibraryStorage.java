import java.util.List;

public interface LibraryStorage {
    void save(Book book);
    List<Book> getAll();
    boolean deleteByTitle(String title);
}
