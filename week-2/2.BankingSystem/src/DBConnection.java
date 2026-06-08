// Import Connection interface
import java.sql.Connection;

// Import DriverManager used to create database connections
import java.sql.DriverManager;

// Import SQLException for error handling
import java.sql.SQLException;

public class DBConnection {

    // Database URL
    private static final String URL =
            "jdbc:mysql://127.0.0.1:3306/banking_db";

    // MySQL username
    private static final String USER = "root";

    // Replace with your MySQL password
    private static final String PASSWORD =
        "2000";

    // Method that returns a Connection object
    public static Connection getConnection() {

        try {

            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create and return database connection
            return DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

        } catch (ClassNotFoundException e) {

            System.out.println(
                    "MySQL Driver not found!"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Database connection failed!"
            );

            e.printStackTrace();
        }

        return null;
    }
}