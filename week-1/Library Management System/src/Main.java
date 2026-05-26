import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Library Management System");

        Scanner sc = new Scanner(System.in);

        Library library = new Library();

        Book b1 = new Book(1, "Harry Potter", "J.K. Rowling");
      
        Book b2  = new Book(2,"The Hobbit", "J.R.R. Tolkien");


        User u1 = new User(101,"vishnu");
        User u2 = new User(102,"kiran");

        library.addBook(b1);
        library.addBook(b2);

        library.addUser(u1);
        library.addUser(u2);

        library.issueBook(1);
        library.issueBook(2);
        library.issueBook(5);

        library.returnBook(1);
        library.returnBook(4);

        library.displayBooks();
        library.displayBookTitles();
        library.displayAvailableBooks();

        while (true){

            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                 case 1:

                    sc.nextLine();

                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    Book newBook = new Book(id, title, author);

                    library.addBook(newBook);

                    break;

                 case 2:
                 library.displayBooks();
                    break;

                 case 3:
                    System.out.println("Issue Book Selected");
                    break;

             case 4:
                    System.out.println("Return Book Selected");
                    break;

             case 5:
                    System.out.println("Exiting...");
                    sc.close();

                    return;

            default:
                    System.out.println("Invalid Choice");

            }
        }
    }
}





