import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    ArrayList<Book> books = new ArrayList<>();
    HashMap<Integer, User> users = new HashMap<>();

    public void addBook(Book book) {

    try {

        for (Book b : books) {

            if (b.id == book.id) {

                throw new Exception("Book ID already exists");
            }
        }

        books.add(book);

        System.out.println("Book added successfully");

    } catch (Exception e) {

        System.out.println(e.getMessage());
    }
}

    public void addUser(User user) {

    try {

        if (users.containsKey(user.id)) {

            throw new Exception("User ID already exists");
        }

        users.put(user.id, user);

        System.out.println("User added successfully");

    } catch (Exception e) {

        System.out.println(e.getMessage());
    }
}

    
   public void issueBook(int bookId, int userId) {

    try {

        Book selectedBook = null;

        for (Book book : books) {

            if (book.id == bookId) {

                selectedBook = book;
                break;
            }
        }

        if (selectedBook == null) {
            throw new Exception("Book not found");
        }

        if (!selectedBook.isAvailable) {
            throw new Exception("Book not available");
        }

        User user = users.get(userId);

        if (user == null) {
            throw new Exception("User not found");
        }

        selectedBook.isAvailable = false;

        user.borrowed.add(selectedBook);

        System.out.println("Book issued successfully");

    } catch (Exception e) {

        System.out.println(e.getMessage());
    }
}
    


    public void returnBook(int bookId, int userId) {

    try {

        User user = users.get(userId);

        if (user == null) {

            throw new Exception("User not found");
        }

        for (Book book : books) {

            if (book.id == bookId) {

                if (!book.isAvailable) {

                    book.isAvailable = true;

                    user.borrowed.remove(book);

                    System.out.println("Book returned successfully");

                    return;

                } else {

                    throw new Exception("Book was not issued");
                }
            }
        }

        throw new Exception("Book not found");

    } catch (Exception e) {

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


    public void displayBorrowedBooks(int userId) {

    try {

        User user = users.get(userId);

        if (user == null) {

            throw new Exception("User not found");
        }

        if (user.borrowed.isEmpty()) {

            System.out.println("No borrowed books");

            return;
        }

        System.out.println("Borrowed Books:");

        for (Book book : user.borrowed) {

            System.out.println(book.title);
        }

    } catch (Exception e) {

        System.out.println(e.getMessage());
    }
}

public void displayAvailableBooks() {

         books.stream()
            .filter(book -> book.isAvailable)
            .forEach(book ->
                    System.out.println(book.title)
            );
}
}

