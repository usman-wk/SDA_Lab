import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws Exception {
        LibraryStorage storage = args.length > 0 && args[0].equalsIgnoreCase("file")
                               ? new FileLibraryStorage("books.txt")
                               : new InMemoryLibraryStorage();          

        Logger logger = new ConsoleLogger();
        LibraryService library = new LibraryComponent(storage, logger);

        Scanner sc = new Scanner(System.in);
        System.out.println("=== Simple Library System ===");

        while (true) {
            System.out.print("\n[A]dd  [D]elete  [L]ist  [Q]uit >> ");
            String cmd = sc.nextLine().trim().toUpperCase();

            switch (cmd) {
                case "A":
                    System.out.print("Title  : ");
                    String title  = sc.nextLine();
                    System.out.print("Author : ");
                    String author = sc.nextLine();
                    library.addBook(new Book(title, author));
                    break;

                case "D":
                    System.out.print("Title to delete: ");
                    String t = sc.nextLine();
                    if (!library.removeBook(t))
                        System.out.println("Book not in library.");
                    break;

                case "L":
                    System.out.println("\nBooks in Library:");
                    library.listBooks().forEach(b -> System.out.println(" • " + b.getDetails()));
                    break;

                case "Q":  sc.close(); return;
                default :  System.out.println("Unknown command!");
            }
        }
    }
}
