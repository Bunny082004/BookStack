import java.util.ArrayList;

public class user {
    protected String name;
    protected int password;
    protected ArrayList<book> bookLog=new ArrayList<>();
    public ArrayList<book> getBookLog() {
        return bookLog;
    }
    public void addBookToLog(book b) {
        bookLog.add(b);
    }
    user(String name,int password){
        this.name=name;
        this.password=password;
    }
    public static void main(String[] args) {
        
    }
}
