// Import Scanner class for taking user input
import java.util.Scanner;

public class BankingSystem {

    // Main method - program execution starts here
    public static void main(String[] args) {

        // Scanner object used to read keyboard input
        Scanner sc = new Scanner(System.in);

        // DAO object used to perform database operations
        CustomerDAO dao = new CustomerDAO();

        // Variable to store menu choice
        int choice;

        // Loop runs until user selects Exit
        do {

            // Display menu
            System.out.println("\n========== BANKING SYSTEM ==========");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Transfer Money");
            System.out.println("6. Exit");

            // Take menu choice from user
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            // Execute operation based on user's choice
            switch (choice) {

                // ADD CUSTOMER
                case 1:

                    // Consume leftover newline
                    sc.nextLine();

                    // Get customer name
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    // Get customer email
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    // Get opening balance
                    System.out.print("Enter Balance: ");
                    double balance = sc.nextDouble();

                    // Create Customer object
                    Customer customer =
                            new Customer(name, email, balance);

                    // Save customer to database
                    dao.addCustomer(customer);

                    break;

                // VIEW ALL CUSTOMERS
                case 2:

                    // Fetch and display all customers
                    dao.viewCustomers();

                    break;

                // UPDATE CUSTOMER
                case 3:

                    // Ask for customer ID
                    System.out.print("Enter Customer ID: ");
                    int updateId = sc.nextInt();

                    // Consume newline
                    sc.nextLine();

                    // Get new name
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    // Get new email
                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();

                    // Get new balance
                    System.out.print("Enter New Balance: ");
                    double newBalance = sc.nextDouble();

                    // Update customer record
                    dao.updateCustomer(
                            updateId,
                            newName,
                            newEmail,
                            newBalance
                    );

                    break;

                // DELETE CUSTOMER
                case 4:

                    // Ask for customer ID
                    System.out.print("Enter Customer ID: ");
                    int deleteId = sc.nextInt();

                    // Delete customer from database
                    dao.deleteCustomer(deleteId);

                    break;

                // TRANSFER MONEY
                case 5:

                    // Ask sender account ID
                    System.out.print("Enter Sender ID: ");
                    int senderId = sc.nextInt();

                    // Ask receiver account ID
                    System.out.print("Enter Receiver ID: ");
                    int receiverId = sc.nextInt();

                    // Ask amount to transfer
                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();

                    // Call transaction method
                    dao.transferMoney(
                            senderId,
                            receiverId,
                            amount
                    );

                    break;

                // EXIT PROGRAM
                case 6:

                    System.out.println("Thank You!");

                    break;

                // INVALID CHOICE
                default:

                    System.out.println(
                            "Invalid Choice! Try Again."
                    );
            }

        } while (choice != 6);

        // Close scanner to prevent resource leak
        sc.close();
    }
}

