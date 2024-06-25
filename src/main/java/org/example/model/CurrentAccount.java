package org.example.model;

public class CurrentAccount extends BankAccount{
    private double overDraft;

    public CurrentAccount(double overDraft) {
        this.overDraft = overDraft;
    }

    public CurrentAccount(double b, String c, double overDraft) {
        super(b, c);
        this.overDraft = overDraft;
    }

    public double getOverDraft() {
        return overDraft;
    }

    public void setOverDraft(double overDraft) {
        this.overDraft = overDraft;
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "overDraft=" + overDraft +
                '}';
    }

    @Override
    public String getType() {
        return "Current-account";
    }
}
