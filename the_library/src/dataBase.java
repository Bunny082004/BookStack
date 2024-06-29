import java.util.*;

public class dataBase {
    protected static ArrayList<book> Library =new ArrayList<>();
    protected static ArrayList<user> userBase =new ArrayList<>();
    public static ArrayList<book> getLibrary() {
        return Library;
    }
    public static void addToLibrary(book Book) {
        Library.add(Book);
        System.out.println("im here");
    }
    public static ArrayList<user> getUserBase() {
        return userBase;
    }
    public static void addToUserBase(user User) {
       userBase.add(User);
    }
    public static void main(String[] args) {
        
    }

}


