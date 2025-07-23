import java.util.Scanner;

// Step 4: BankAccount class to store user's account balance
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid or insufficient balance for withdrawal!");
        }
    }

    public double getBalance() {
        return balance;
    }
}

// Step 1 & 2: ATM class with user interface and methods
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);
    }

    // Step 3: Implement checkBalance()
    private void checkBalance() {
        System.out.println("Current Balance: $" + account.getBalance());
    }
}

// Step 5: Connect ATM to BankAccount
public class ATMInterface {
    public static void main(String[] args) {
        // Create account with initial balance
        BankAccount userAccount = new BankAccount(1000.00);

        // Pass account to ATM
        ATM atm = new ATM(userAccount);

        // Show menu
        atm.showMenu();
    }
}
