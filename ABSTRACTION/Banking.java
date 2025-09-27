abstract class BankAccount {
    private int accountNumber;
    private String holderName;
    private double balance;

    BankAccount(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    abstract void calculateInterest();

    public void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

interface Loanable {
    public void applyForLoan();
    public void calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
    double interestRate = 0.04;

    SavingsAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    void calculateInterest() {
        double interest = getBalance() * interestRate;
        System.out.println("Savings Account Interest: " + interest);
    }

    public void applyForLoan() {
        System.out.println("Savings Account Loan request received.");
    }

    public void calculateLoanEligibility() {
        if (getBalance() > 20000) {
            System.out.println("Eligible for loan.");
        } else {
            System.out.println("Not eligible for loan.");
        }
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    double interestRate = 0.02;

    CurrentAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    void calculateInterest() {
        double interest = getBalance() * interestRate;
        System.out.println("Current Account Interest: " + interest);
    }

    public void applyForLoan() {
        System.out.println("Current Account Loan request received.");
    }

    public void calculateLoanEligibility() {
        if (getBalance() > 50000) {
            System.out.println("Eligible for loan.");
        } else {
            System.out.println("Not eligible for loan.");
        }
    }
}

public class Banking{
    public static void main(String[] args) {
        BankAccount acc1 = new SavingsAccount(101, "Simran", 25000);
        BankAccount acc2 = new CurrentAccount(102, "Christopher", 40000);

        acc1.display();
        acc1.deposit(5000);
        acc1.withdraw(3000);
        acc1.calculateInterest();
        ((Loanable)acc1).applyForLoan();
        ((Loanable)acc1).calculateLoanEligibility();

        System.out.println();

        acc2.display();
        acc2.deposit(10000);
        acc2.withdraw(15000);
        acc2.calculateInterest();
        ((Loanable)acc2).applyForLoan();
        ((Loanable)acc2).calculateLoanEligibility();
    }
}
