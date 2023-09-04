public class LibraryApp {
    public static void main(String[] args) {
        // Create a DatabaseManager instance
        DatabaseManager databaseManager = new DatabaseManager();

        // the program will start from here 
        LibraryUI libraryUI = new LibraryUI(databaseManager);
        libraryUI.start();
    }
}
