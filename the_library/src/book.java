import java.util.*;

public class book {
    protected String bookName;
    protected int bookID;
    protected ArrayList<user> userLog =new ArrayList<>();
    
    public ArrayList<user> getUserLog() {
        return userLog;
    }

    public void addUserToLog(user u) {
        userLog.add(u);
    }

    book(String name,int bookID){
        this.bookName=name;
        this.bookID=bookID;
    }
    
    public static void main(String[] args) {
        
    }
}
