import java.util.Random;
import java.util.Scanner;

public class App {

    public static void addBook(String name){
        Random random = new Random();
        int min = 100; // Minimum value
        int max = 999; // Maximum value
        int randomInt = random.nextInt((max - min) + 1) + min;
        book b=new book(name, randomInt);
        dataBase.addToLibrary(b);
        System.out.println(name+" succesfully added");

    }
    public static void addUser(String name , int passkey){
        
        user u=new user(name, passkey);
        dataBase.addToUserBase(u);
        System.out.println("User added");
        System.out.println("Please remember username and Password for future purposes");
    }
    public static int getindex(String uname,int Key){
        int index=-1;
        for(user i:dataBase.userBase){
            int j=0;
            if(i.name.equals(uname)){
                if(i.password==Key){
                    return j;
                }
            }
            j++;
        }
        return index;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //Starting Page
        // System.out.println("Welcome to the library.");
        // System.out.println("Please Select an Option");
        // System.out.println("1-Add Book");
        // System.out.println("2-Sign up(New User)");
        // System.out.println("3-Sign in(Exsiting User)");
        // System.out.println("4-to exit");
        
        //End of Starting Page

        //To add a Book to Library
        while(true){
            System.out.println("Welcome to the library.");
            System.out.println("Please Select an Option");
            System.out.println("1-Add Book");
            System.out.println("2-Sign up(New User)");
            System.out.println("3-Sign in(Exsiting User)");
            System.out.println("4-to exit");
            System.out.println("choose");
            int input= sc.nextInt();
            if(input==1){
                System.out.println("please provide the name");
                String bname=sc.next();
                addBook(bname);
            }else if(input==2){
                System.out.println("Welcome to sign up page");
                System.out.println("Set a User name");
                String uname= sc.next();
                System.out.println("Set a password");
                int passkey=sc.nextInt();
                addUser(uname, passkey);
            }else if(input==3){
                System.out.println("PLease provide username and Password");
                String name =sc.next();
                int Key=sc.nextInt();
                int index=getindex(name, Key);
                boolean t=true;
                while (t) {
                    if(index==-1){
                        System.out.println("wrong password/user not available");
                        System.out.println("press 1 to exist or 2 to try again");
                        int o=sc.nextInt();
                        if(o==1){
                            return;
                        }else{
                            System.out.println("PLease provide username and Password");
                            name =sc.next();
                            Key=sc.nextInt();
                            index=getindex(name, Key);
                        }
                    }else{
                        t=false;

                    }
                }
                
                System.out.println("Please check the available books and selct to buy");
                int j=0;
                for(book i:dataBase.getLibrary()){
                    
                    System.out.print(j);
                    System.out.println(" - "+i.bookName);
                    j++;
                }
                System.out.println("choose one book");
                int c=sc.nextInt();
                dataBase.Library.get(c).addUserToLog(dataBase.userBase.get(index));
                dataBase.userBase.get(index).addBookToLog(dataBase.Library.get(c));

            }else if(input==4){
                return;
            }
        }
        
    }
}
