import java.util.HashMap;
import java.util.Scanner;

class Account {
    private String name;
    private double balance;

    public Account(String name) {
        this.name = name;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited successfully.");
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class OnlineBankingSystem {
    private static HashMap<String, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to Online Banking System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = scanner.next();
                    createAccount(name);
                    break;
                case 2:
                    System.out.print("Enter your name: ");
                    String depositor = scanner.next();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositor, depositAmount);
                    break;
                case 3:
                    System.out.print("Enter your name: ");
                    String withdrawer = scanner.next();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawer, withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter your name: ");
                    String balanceChecker = scanner.next();
                    checkBalance(balanceChecker);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Thank you for using Online Banking System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void createAccount(String name) {
        if (!accounts.containsKey(name)) {
            Account account = new Account(name);
            accounts.put(name, account);
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Account already exists.");
        }
    }

    private static void deposit(String name, double amount) {
        Account account = accounts.get(name);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdraw(String name, double amount) {
        Account account = accounts.get(name);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void checkBalance(String name) {
        Account account = accounts.get(name);
        if (account != null) {
            System.out.println("Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }
}