import java.util.List;

public class LibraryComponent implements LibraryService {
    private final LibraryStorage storage;
    private final Logger logger;

    public LibraryComponent(LibraryStorage storage, Logger logger) {
        this.storage = storage;
        this.logger  = logger;
    }

    @Override
    public void addBook(Book book) {
        storage.save(book);
        logger.info("Added   : " + book.getDetails());
    }

    @Override
    public List<Book> listBooks() {
        return storage.getAll();
    }

    @Override
    public boolean removeBook(String title) {
        boolean ok = storage.deleteByTitle(title);
        logger.info(ok ? "Deleted : " + title : "Not found: " + title);
        return ok;
    }
}
