public class Customer {

    // Customer ID from database
    private int id;

    // Customer name
    private String name;

    // Customer email
    private String email;

    // Customer account balance
    private double balance;

    // Default Constructor
    // Used when creating an empty Customer object
    public Customer() {
    }

    // Constructor without ID
    // Used when inserting a new customer
    public Customer(String name,
                    String email,
                    double balance) {

        this.name = name;
        this.email = email;
        this.balance = balance;
    }

    // Constructor with ID
    // Used when retrieving customer from database
    public Customer(int id,
                    String name,
                    String email,
                    double balance) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.balance = balance;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Setter for ID
    public void setId(int id) {
        this.id = id;
    }

    // Getter for Name
    public String getName() {
        return name;
    }

    // Setter for Name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for Email
    public String getEmail() {
        return email;
    }

    // Setter for Email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for Balance
    public double getBalance() {
        return balance;
    }

    // Setter for Balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // toString method
    // Controls how object data is displayed
    @Override
    public String toString() {

        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                '}';
    }
}

