import java.util.ArrayList;
import java.util.Optional;

public class EmployeeManager {

    // Stores all employee records
    private ArrayList<Employee> employees = new ArrayList<>();

    // Adds employee to the list
    public void addEmployee(Employee employee) {

        employees.add(employee);

        System.out.println("Employee added successfully.");
    }

    // Displays all employees
    public void viewEmployees() {

        // Check if employee list is empty
        if (employees.isEmpty()) {

            System.out.println("No employees found.");
            return;
        }

        // Display each employee
        for (Employee employee : employees) {

            System.out.println(employee);
        }
    }

    // Searches employee by ID
    public Optional<Employee> searchEmployeeById(int id) {

        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst();
    }

    // Removes employee using employee ID
    public void removeEmployee(int id) throws EmployeeNotFoundException {

        Optional<Employee> employeeOptional = searchEmployeeById(id);

        // Check if employee exists
        if (employeeOptional.isPresent()) {

            employees.remove(employeeOptional.get());

            System.out.println("Employee removed successfully.");

        } else {

            throw new EmployeeNotFoundException(
                    "Employee not found with ID: " + id);
        }
    }
}