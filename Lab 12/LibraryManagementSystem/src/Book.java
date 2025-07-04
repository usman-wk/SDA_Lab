public class Book {
    private final String title;
    private final String author;

    public Book(String title, String author) {
        this.title  = title;
        this.author = author;
    }

    public String getTitle()   { return title;  }
    public String getAuthor()  { return author; }

    public String getDetails() { return title + " by " + author; }

    @Override
    public String toString() { return getDetails(); }
}
