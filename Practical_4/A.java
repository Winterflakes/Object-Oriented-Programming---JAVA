package Practical_4;

// Main class
public class A {
    public static void main(String[] args) {
        SavingAccount savingAccount = new SavingAccount("1234567890", "John Doe");
        FixedDepositAccount fixedDepositAccount = new FixedDepositAccount("0987654321", "Jane Smith", 3);

        savingAccount.openAccount();
        savingAccount.deposit(5000);
        savingAccount.updateInterest();
        savingAccount.withdraw(2000);
        savingAccount.closeAccount();

        System.out.println("--------------------");

        fixedDepositAccount.openAccount();
        fixedDepositAccount.deposit(10000);
        fixedDepositAccount.updateInterest();
        fixedDepositAccount.closeAccount();
    }
}
// Interface Debitable
interface Debitable {
    void withdraw(double amount);
}

// Class BankAccount
class BankAccount {
    private static int accountCounter = 10001; // Starting account number
    protected int accountNumber;
    protected String aadharNumber;
    protected String ownerName;
    protected double roi;
    protected double balance;

    public BankAccount(String aadharNumber, String ownerName) {
        this.accountNumber = accountCounter++;
        this.aadharNumber = aadharNumber;
        this.ownerName = ownerName;
        this.roi = 0.0;
        this.balance = 0.0;
    }

    public void openAccount() {
        System.out.println("Account opened successfully.");
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Current balance: " + balance);
    }

    public void closeAccount() {
        balance = 0.0;
        System.out.println("Account closed successfully.");
    }

    public void updateInterest() {
        double interest = balance * roi / 100;
        balance += interest;
        System.out.println("Interest updated. Current balance: " + balance);
    }
}

// Class FixedDepositAccount
class FixedDepositAccount extends BankAccount {
    private int lockInPeriod;

    public FixedDepositAccount(String aadharNumber, String ownerName, int lockInPeriod) {
        super(aadharNumber, ownerName);
        this.lockInPeriod = lockInPeriod;
        this.roi = calculateROI(lockInPeriod);
    }

    private double calculateROI(int lockInPeriod) {
        if (lockInPeriod >= 5) {
            return 7.0;
        } else if (lockInPeriod >= 2) {
            return 6.5;
        } else {
            return 6.0;
        }
    }

    @Override
    public void updateInterest() {
        double interest = balance * roi / 100;
        balance += interest;
        System.out.println("Simple Interest updated. Current balance: " + balance);
    }

    @Override
    public void closeAccount() {
        if (lockInPeriod <= 0) {
            double closureCharge = balance * 5 / 100;
            balance -= closureCharge;
            super.closeAccount();
        } else {
            System.out.println("Cannot close account before lock-in period of " + lockInPeriod + " years.");
        }
    }
}

// Class SavingAccount
class SavingAccount extends BankAccount implements Debitable {
    public SavingAccount(String aadharNumber, String ownerName) {
        super(aadharNumber, ownerName);
        this.roi = 4.0;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}



