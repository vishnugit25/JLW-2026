import java.util.ArrayList;

public class User {
    int id;
    String name;

    ArrayList<Book> borrowed = new ArrayList<>();

    public User(int id, String name){
        this.id = id;
        this.name = name;
        
    }
}
