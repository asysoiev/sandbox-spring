package com.sandbox.concurrency;

/**
 * Created by andrii on 21.08.17.
 */
public class Account {
    private final long id;
    private int balance;

    public Account(long id, int initialBalance) {
        this.id = id;
        this.balance = initialBalance;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}
