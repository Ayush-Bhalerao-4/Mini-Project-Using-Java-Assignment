import java.io.*;
import java.util.*;

// User-defined Exceptions
class InvalidAmountException extends Exception {
    public InvalidAmountException(String msg) {
        super(msg);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}

class InvalidCustomerIdException extends Exception {
    public InvalidCustomerIdException(String msg) {
        super(msg);
    }
}

class Customer {
    int cid;
    String cname;
    double amount;

    public Customer(int cid, String cname, double amount)
            throws InvalidCustomerIdException, InvalidAmountException {

        if (cid < 1 || cid > 20)
            throw new InvalidCustomerIdException("CID must be between 1 and 20");

        if (amount < 1000)
            throw new InvalidAmountException("Minimum balance must be Rs. 1000");

        this.cid = cid;
        this.cname = cname;
        this.amount = amount;
    }

    public void deposit(double amt) throws InvalidAmountException {
        if (amt <= 0)
            throw new InvalidAmountException("Amount must be positive");

        amount += amt;
    }

    public void withdraw(double amt)
            throws InvalidAmountException, InsufficientBalanceException {

        if (amt <= 0)
            throw new InvalidAmountException("Amount must be positive");

        if (amt > amount)
            throw new InsufficientBalanceException("Insufficient balance");

        amount -= amt;
    }

    public void display() {
        System.out.println(cid + " " + cname + " " + amount);
    }

    public String toFileString() {
        return cid + "," + cname + "," + amount;
    }
}

public class BankingSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Customer> customers = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display All");
            System.out.println("5. Save to File");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter CID (1-20): ");
                        int cid = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Initial Amount: ");
                        double amt = sc.nextDouble();

                        Customer c = new Customer(cid, name, amt);
                        customers.add(c);

                        System.out.println("Account created successfully!");
                        break;

                    case 2:
                        System.out.print("Enter CID: ");
                        cid = sc.nextInt();

                        System.out.print("Enter Deposit Amount: ");
                        amt = sc.nextDouble();

                        for (Customer cust : customers) {
                            if (cust.cid == cid) {
                                cust.deposit(amt);
                                System.out.println("Amount deposited!");
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Enter CID: ");
                        cid = sc.nextInt();

                        System.out.print("Enter Withdraw Amount: ");
                        amt = sc.nextDouble();

                        for (Customer cust : customers) {
                            if (cust.cid == cid) {
                                cust.withdraw(amt);
                                System.out.println("Amount withdrawn!");
                            }
                        }
                        break;

                    case 4:
                        for (Customer cust : customers) {
                            cust.display();
                        }
                        break;

                    case 5:
                        FileWriter fw = new FileWriter("customers.txt");
                        for (Customer cust : customers) {
                            fw.write(cust.toFileString() + "\n");
                        }
                        fw.close();
                        System.out.println("Data saved to file.");
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (InvalidCustomerIdException |
                     InvalidAmountException |
                     InsufficientBalanceException e) {

                System.out.println("Error: " + e.getMessage());

            } catch (IOException e) {
                System.out.println("File Error: " + e.getMessage());
            }

        } while (choice != 6);

        sc.close();
    }
}