import java.util.List;

public interface LibraryService {
    void addBook(Book book);
    List<Book> listBooks();
    boolean removeBook(String title);  
}
