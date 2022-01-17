//package Bank_Managment;

public class Customer {

    private double balance = 0;

    public Customer(double initBalance) {
        this.balance = initBalance;
    }

    public void deposit(double depositAmount) {
        this.balance = this.balance + depositAmount;
        System.out.println(balance);
    }

    public void Withdrawal(double WithdrawalAmount) {
        this.balance = this.balance - WithdrawalAmount;
        System.out.println(balance);
    }
}
