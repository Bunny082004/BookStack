import java.util.ArrayList;
import java.util.List;

public class DataBase1 { // Changed to DataBase
    private static DataBase1 theAlley;

    // Two ArrayList instances
    private List<book> library; // Changed to follow Java naming conventions
    private List<user> userBase; // Changed to follow Java naming conventions

    // Private constructor to prevent instantiation
    private DataBase1() {
        // Initialize the ArrayLists
        library = new ArrayList<>();
        userBase = new ArrayList<>();
    }

    // Public static method to provide access to the instance
    public static DataBase1 getInstance() {
        if (theAlley == null) {
            synchronized (DataBase1.class) {
                if (theAlley == null) {
                    theAlley = new DataBase1();
                    System.out.println("Creating new instance");
                }
            }
        }
        return theAlley;
    }

    // Method to add an element to library
    public void addToLibrary(book Book) {
        library.add(Book);
    }

    // Method to add an element to userBase
    public void addToUserBase(user User) {
        userBase.add(User);
    }

    // Method to get library
    public List<book> getLibrary() {
        return library;
    }

    // Method to get userBase
    public List<user> getUserBase() {
        return userBase;
    }

    public static void main(String[] args) {
        // Test the singleton instance
        DataBase1 db1 = DataBase1.getInstance();
        //db1.addToLibrary(new book("Book1",5586)); // Assuming Book class has a constructor accepting a String
        db1.addToUserBase(new user("User1",5003)); // Assuming User class has a constructor accepting a String

        DataBase1 db2 = DataBase1.getInstance();
        db2.addToLibrary(new book("Book3",5586)); // Assuming Book class has a constructor accepting a String
        System.out.println(db1 == db2); // Should print true, indicating same instance

        System.out.println("Library: " + db1.getLibrary());
        System.out.println("UserBase: " + db1.getUserBase());
    }
}
