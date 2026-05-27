import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // System.out.println("Library Management System");

        Scanner sc = new Scanner(System.in);

        Library library = new Library();

        Book b1 = new Book(1, "Harry Potter", "J.K. Rowling");
      
        Book b2  = new Book(2,"The Hobbit", "J.R.R. Tolkien");

        Book b3  = new Book(3,"Game of thrones", "George R.R. Martin");

        Book b4  = new Book(4,"The Blade Itself", "Joe Abercrombie");

        Book b5  = new Book(5,"Fourth Wing", "Rebecca Yarros");


        User u1 = new User(101,"vishnu");
        User u2 = new User(102,"kiran");

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);
        library.addBook(b4);
        library.addBook(b5);

        library.addUser(u1);
        library.addUser(u2);

        library.issueBook(1,101);
        library.issueBook(2,102);
        library.issueBook(5,102);

        library.returnBook(1,101);
        library.returnBook(5,102);

        library.displayBooks();
        library.displayBookTitles();
        library.displayAvailableBooks();

        while (true){

            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Add User");
            System.out.println("6. Display Borrowed Books");
            System.out.println("7. Display Available Books");
            System.out.println("8. Exit");

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

                    System.out.print("Enter Book ID: ");
                    int issueBookId = sc.nextInt();

                    System.out.print("Enter User ID: ");
                    int issueUserId = sc.nextInt();

                    if (!library.users.containsKey(issueUserId)) {

                        sc.nextLine();

                        System.out.print("User not found. Enter User Name: ");
                        String newUserName = sc.nextLine();

                        User newUser = new User(issueUserId, newUserName);

                        library.addUser(newUser);
                    }

                    library.issueBook(issueBookId, issueUserId);

                    break;

                case 4:

                    System.out.print("Enter Book ID: ");
                    int returnBookId = sc.nextInt();

                    System.out.print("Enter User ID: ");
                    int returnUserId = sc.nextInt();

                    library.returnBook(returnBookId, returnUserId);

                    break;

                case 5:

                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter User Name: ");
                    String userName = sc.nextLine();

                    User user = new User(userId, userName);

                    library.addUser(user);

                    break;

                case 6:

                    System.out.print("Enter User ID: ");

                    int borrowedUserId = sc.nextInt();

                    library.displayBorrowedBooks(borrowedUserId);

                    break;

                case 7:

                    library.displayAvailableBooks();

                    break;
                    
                    
                case 8:

                    System.out.println("Exiting...");

                    sc.close();

                    return;


            default:
                    System.out.println("Invalid Choice");

            }
        }
    }
}





