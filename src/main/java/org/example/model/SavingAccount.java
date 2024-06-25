package org.example.model;

public class SavingAccount extends BankAccount{
    private double interestRate;

    public SavingAccount(double interestRate) {
        this.interestRate = interestRate;
    }

    public SavingAccount(double b, String c, double interestRate) {
        super(b, c);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                "interstRate=" + interestRate +
                '}';
    }

    @Override
    public String getType() {
        return "Saving-account";
    }
}
