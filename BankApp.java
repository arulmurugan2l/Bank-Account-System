import java.util.*;

class Account {
    private int accNo;
    private String name;
    private double balance;

    Account(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }
    int getAccNo() { return accNo; }
    String getName() { return name; }
    double getBalance() { return balance; }

    void deposit(double amt) {
        if (amt <= 0) { System.out.println("Invalid amount"); return; }
        balance += amt;
        System.out.println("Deposited. Balance: " + balance);
    }
    void withdraw(double amt) {
        if (amt <= 0 || amt > balance) {
            System.out.println("Invalid / insufficient balance");
            return;
        }
        balance -= amt;
        System.out.println("Withdrawn. Balance: " + balance);
    }
}

public class BankApp {
    static Map<Integer, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nextNo = 1001;
        while (true) {
            System.out.println("\n1.Create 2.Deposit 3.Withdraw 4.Balance 5.Exit");
            int ch = sc.nextInt();
            if (ch == 5) break;
            if (ch == 1) {
                System.out.print("Name: ");
                String n = sc.next();
                accounts.put(nextNo, new Account(nextNo, n, 0));
                System.out.println("Account created. No: " + nextNo++);
                continue;
            }
            System.out.print("Account No: ");
            Account a = accounts.get(sc.nextInt());
            if (a == null) { System.out.println("Account not found"); continue; }
            if (ch == 2) { System.out.print("Amount: "); a.deposit(sc.nextDouble()); }
            else if (ch == 3) { System.out.print("Amount: "); a.withdraw(sc.nextDouble()); }
            else if (ch == 4) System.out.println(a.getName() + " Balance: " + a.getBalance());
        }
        System.out.println("Thank you!");
    }
}
