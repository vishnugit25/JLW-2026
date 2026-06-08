// Import JDBC classes
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDAO {


    // CREATE CUSTOMER

    public void addCustomer(Customer customer) {

        // SQL query to insert customer
        String sql =
                "INSERT INTO customers(name, email, balance) VALUES (?, ?, ?)";

        try (
                // Get database connection
                Connection con = DBConnection.getConnection();

                // Prepare SQL statement
                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            // Set values into placeholders
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getEmail());
            ps.setDouble(3, customer.getBalance());

            // Execute insert query
            int rows = ps.executeUpdate();

            // Check if insertion was successful
            if (rows > 0) {
                System.out.println("Customer Added Successfully!");
            }

        } catch (SQLException e) {

            System.out.println("Error Adding Customer!");
            e.printStackTrace();
        }
    }

    
    // VIEW ALL CUSTOMERS
    
    public void viewCustomers() {

        // SQL query to fetch all customers
        String sql = "SELECT * FROM customers";

        try (
                Connection con = DBConnection.getConnection();

                Statement stmt = con.createStatement();

                ResultSet rs = stmt.executeQuery(sql)
        ) {

            System.out.println("\n===== CUSTOMER LIST =====");

            // Loop through each row
            while (rs.next()) {

                System.out.println(
                        "ID: " + rs.getInt("id")
                                + " | Name: " + rs.getString("name")
                                + " | Email: " + rs.getString("email")
                                + " | Balance: " + rs.getDouble("balance")
                );
            }

        } catch (SQLException e) {

            System.out.println("Error Fetching Customers!");
            e.printStackTrace();
        }
    }

    
    // UPDATE CUSTOMER
    
    public void updateCustomer(
            int id,
            String name,
            String email,
            double balance
    ) {

        // SQL query for update
        String sql =
                "UPDATE customers SET name=?, email=?, balance=? WHERE id=?";

        try (
                Connection con = DBConnection.getConnection();

                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            // Set updated values
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setDouble(3, balance);
            ps.setInt(4, id);

            // Execute update
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Customer Updated Successfully!");
            } else {
                System.out.println("Customer Not Found!");
            }

        } catch (SQLException e) {

            System.out.println("Error Updating Customer!");
            e.printStackTrace();
        }
    }

    
    // DELETE CUSTOMER
    public void deleteCustomer(int id) {

        // SQL query to delete customer
        String sql =
                "DELETE FROM customers WHERE id=?";

        try (
                Connection con = DBConnection.getConnection();

                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            // Set customer id
            ps.setInt(1, id);

            // Execute delete
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Customer Deleted Successfully!");
            } else {
                System.out.println("Customer Not Found!");
            }

        } catch (SQLException e) {

            System.out.println("Error Deleting Customer!");
            e.printStackTrace();
        }
    }


    // TRANSFER MONEY
    public void transferMoney(
            int senderId,
            int receiverId,
            double amount
    ) {

        // Deduct money from sender
        String deductSql =
                "UPDATE customers SET balance = balance - ? WHERE id = ?";

        // Add money to receiver
        String addSql =
                "UPDATE customers SET balance = balance + ? WHERE id = ?";

        Connection con = null;

        try {

            // Get connection
            con = DBConnection.getConnection();

            // Disable auto commit
            con.setAutoCommit(false);

            // Deduct amount
            PreparedStatement deductStmt =
                    con.prepareStatement(deductSql);

            deductStmt.setDouble(1, amount);
            deductStmt.setInt(2, senderId);

            deductStmt.executeUpdate();

            // Add amount
            PreparedStatement addStmt =
                    con.prepareStatement(addSql);

            addStmt.setDouble(1, amount);
            addStmt.setInt(2, receiverId);

            addStmt.executeUpdate();

            // Save both changes permanently
            con.commit();

            System.out.println("Transfer Successful!");

        } catch (Exception e) {

            try {

                if (con != null) {

                    // Undo all changes
                    con.rollback();

                    System.out.println(
                            "Transaction Failed! Changes Rolled Back."
                    );
                }

            } catch (SQLException ex) {

                ex.printStackTrace();
            }

            e.printStackTrace();

        } finally {

            try {

                if (con != null) {

                    // Re-enable auto commit
                    con.setAutoCommit(true);

                    // Close connection
                    con.close();
                }

            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
    }
}
