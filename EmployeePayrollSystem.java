import java.util.ArrayList;
import java.util.Scanner;

// 1. MAIN PUBLIC CLASS AT THE TOP
public class EmployeePayrollSystem {
    public static void main(String[] args) {
        ArrayList<Employee> employeeList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("=== SIMPLE EMPLOYEE PAYROLL SYSTEM ===");

        do {
            System.out.println("\n1. Add New Employee");
            System.out.println("2. View All Records");
            System.out.println("3. Search by ID");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            
            // Basic check to ensure the user enters a number
            while (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                sc.next(); 
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    sc.nextLine(); // Clear the buffer
                    String name = sc.nextLine();
                    
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    
                    System.out.print("Base Salary: ");
                    double salary = sc.nextDouble();
                    
                    System.out.print("Allowances: ");
                    double allow = sc.nextDouble();
                    
                    System.out.print("Deductions: ");
                    double deduct = sc.nextDouble();

                    // Creating object and adding to list
                    Employee newEmp = new Employee(name, id, salary, allow, deduct);
                    employeeList.add(newEmp);
                    System.out.println("Successfully Added!");
                    break;

                case 2:
                    System.out.println("\n--- ALL EMPLOYEE DATA ---");
                    if (employeeList.isEmpty()) {
                        System.out.println("No records found.");
                    } else {
                        for (Employee e : employeeList) {
                            e.showData();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Search ID: ");
                    int searchId = sc.nextInt();
                    boolean found = false;
                    for (Employee e : employeeList) {
                        if (e.getEmpId() == searchId) {
                            e.showData();
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("ID not found in system.");
                    break;

                case 4:
                    System.out.println("Closing program...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 4);
        
        sc.close();
    }
}

// 2. HELPER CLASS (MUST NOT BE PUBLIC)
class Employee {
    private String name;
    private int empId;
    private double baseSalary;
    private double allowances;
    private double deductions;

    // Constructor
    public Employee(String name, int empId, double baseSalary, double allowances, double deductions) {
        this.name = name;
        this.empId = empId;
        this.baseSalary = baseSalary;
        this.allowances = allowances;
        this.deductions = deductions;
    }

    // Calculation Logic
    public double getNetSalary() {
        return (baseSalary + allowances) - deductions;
    }

    public int getEmpId() {
        return empId;
    }

    // Display Logic
    public void showData() {
        System.out.println("ID: " + empId + " | Name: " + name + " | Net: " + getNetSalary());
    }
}
