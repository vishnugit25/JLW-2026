import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    ArrayList<Book> books = new ArrayList<>();
    HashMap<Integer, User> users = new HashMap<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully");
    }

    public void addUser(User user) {
    users.put(user.id, user);
    System.out.println("User added successfully");
    }

    
    public void issueBook(int bookId){
        try{
            for(Book book : books){
                if(book.id == bookId){
                    if (book.isAvailable){
                        book.isAvailable = false;

                        System.out.println("Book issued Successfully");
                        return;
                    } else{
                        throw new Exception("Book not Available");
                    }
                    
                }
            }
            throw new Exception("Book not found");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
    }


    public void returnBook(int bookId){
     try {
        for (Book book: books){
            if(book.id == bookId){
                if(!book.isAvailable){
                    book.isAvailable = true;

                    System.out.println("book successfully return");
                    return;
                }  else {
                    throw new Exception("Book was not issued");
                }
                
            }
        } throw new Exception("Book not found");
    } catch (Exception e){
        System.out.println(e.getMessage());

    }
        
    }

    public void displayBooks() {

    for (Book book : books) {

        System.out.println("ID: " + book.id);
        System.out.println("Title: " + book.title);
        System.out.println("Author: " + book.author);
        System.out.println("Available: " + book.isAvailable);

        System.out.println("-------------------");
    }
    }


    public void displayBookTitles(){
        books.forEach(book ->
            System.out.println(book.title)
        );
    }


    public void displayAvailableBooks() {

         books.stream()
            .filter(book -> book.isAvailable)
            .forEach(book ->
                    System.out.println(book.title)
            );
}
}

