import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LibraryUI {
    private DatabaseManager databaseManager;
    private Scanner scanner;

    public LibraryUI(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("Library Inventory Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search by Title");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    searchBooks();
                    break;
                case 4:
                    updateBook();
                    break;
                case 5:
                    deleteBook();
                    break;
                case 6:
                    System.out.println("Exiting the application.");
                    databaseManager.closeConnection();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        databaseManager.addBook(title, author);
        System.out.println("Book added.");
    }

    private void viewBooks() {
        ResultSet resultSet = databaseManager.getAllBooks();
        displayBooks(resultSet);
    }

    private void searchBooks() {
        System.out.print("Enter title to search: ");
        String searchTitle = scanner.nextLine();
        ResultSet resultSet = databaseManager.searchBooksByTitle(searchTitle);
        displayBooks(resultSet);
    }

    private void updateBook() {
        System.out.print("Enter book ID to update: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter new title: ");
        String title = scanner.nextLine();
        System.out.print("Enter new author: ");
        String author = scanner.nextLine();
        databaseManager.updateBook(bookId, title, author);
        System.out.println("Book updated.");
    }

    private void deleteBook() {
        System.out.print("Enter book ID to delete: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();  
        databaseManager.deleteBook(bookId);
        System.out.println("Book deleted.");
    }

    private void displayBooks(ResultSet resultSet) {
        try {
            System.out.println("Books in the Library:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") +
                        ", Title: " + resultSet.getString("title") +
                        ", Author: " + resultSet.getString("author"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
