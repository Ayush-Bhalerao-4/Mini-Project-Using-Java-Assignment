import java.util.Scanner;

class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void displaySalary() {
        System.out.println("\nEmployee Name : " + name);
        System.out.println("Salary Before Hike : " + salary);
    }
}

class FullTimeEmployee extends Employee {

    public FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    public void calculateSalary() {
        double newSalary = salary + (salary * 0.50);
        System.out.println("Salary After 50% Hike : " + newSalary);
    }
}

class InternEmployee extends Employee {

    public InternEmployee(String name, double salary) {
        super(name, salary);
    }

    public void calculateSalary() {
        double newSalary = salary + (salary * 0.25);
        System.out.println("Salary After 25% Hike : " + newSalary);
    }
}

public class HierarchicalInheritance {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.println("\nEmployee " + (i + 1));
            System.out.println("Select Employee Type:");
            System.out.println("1. Full Time Employee");
            System.out.println("2. Intern Employee");
            System.out.print("Enter choice (1 or 2): ");
            int choice = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            if (choice == 1) {
                FullTimeEmployee ft = new FullTimeEmployee(name, salary);
                ft.displaySalary();
                ft.calculateSalary();
            } 
            else if (choice == 2) {
                InternEmployee intern = new InternEmployee(name, salary);
                intern.displaySalary();
                intern.calculateSalary();
            } 
            else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}