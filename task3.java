import java.util.Scanner;

class BankAccount {
    double balance;

    BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            balance = 0;
        } else {
            balance = initialBalance;
        }
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Not enough balance.");
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        }
    }

    void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }
}

public class task3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BankAccount myAccount = new BankAccount(500); // starting with $500

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = input.nextInt();

            if (choice == 1) {
                System.out.print("Enter amount to withdraw: ");
                double amount = input.nextDouble();
                myAccount.withdraw(amount);
            } else if (choice == 2) {
                System.out.print("Enter amount to deposit: ");
                double amount = input.nextDouble();
                myAccount.deposit(amount);
            } else if (choice == 3) {
                myAccount.checkBalance();
            } else if (choice == 4) {
                System.out.println("Thank you for using the ATM.");
                break;
            } else {
                System.out.println("Invalid option, try again.");
            }
        }

        input.close();
    }
}
