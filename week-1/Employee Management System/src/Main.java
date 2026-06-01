import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeManager manager = new EmployeeManager();

        int choice;

        do {

            // Display menu
            System.out.println("\n===== Employee Management System =====");

            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Remove Employee");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    // Add employee
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    Employee employee = new Employee(id, name, department, salary);

                    manager.addEmployee(employee);

                    break;

                case 2:

                    // View employees
                    manager.viewEmployees();

                    break;

                case 3:

                    // Search employee
                    System.out.print("Enter Employee ID to search: ");

                    int searchId = sc.nextInt();

                    Optional<Employee> foundEmployee =
                            manager.searchEmployeeById(searchId);

                    if (foundEmployee.isPresent()) {

                        System.out.println(foundEmployee.get());

                    } else {

                        System.out.println("Employee not found.");
                    }

                    break;

                case 4:

                    // Remove employee
                    System.out.print("Enter Employee ID to remove: ");

                    int removeId = sc.nextInt();

                    try {

                        manager.removeEmployee(removeId);

                    } catch (EmployeeNotFoundException e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case 5:

                    System.out.println("Exiting program...");
                    break;

                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}