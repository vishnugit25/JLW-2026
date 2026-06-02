public class Book {
    int id;
    String title;
    String author;
    boolean isAvailable;
    int issuedTo;


    public Book(int id, String title, String author){

        this.id = id;
        this.title = title;
        this.author = author;
        
        this.isAvailable = true;

        issuedTo = -1;


    }
}
