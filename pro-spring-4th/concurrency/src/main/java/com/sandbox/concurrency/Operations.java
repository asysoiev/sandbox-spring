package com.sandbox.concurrency;

/**
 * Created by andrii on 20.08.17.
 */
public class Operations {

    public static void main(String[] args) {
        Account a = new Account(1, 1000);
        Account b = new Account(2, 2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    transfer(a, b, 500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            transfer(b, a, 300);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("AccountA:" + a);
        System.out.println("AccountB:" + b);
    }

    private static void transfer(Account source, Account destination, int amount) throws InsufficientFundsException, InterruptedException {
        System.out.println("Transfer before. Amount: " + amount);
        System.out.println("Source:" + source);
        System.out.println("Destination:" + destination);
        if (source.getBalance() < amount) {
            throw new InsufficientFundsException();
        }

        synchronized (source) {
            System.out.println("Locked source");
            Thread.sleep(100);//dead lock
            synchronized (destination) {
                System.out.println("Locked destination");
                source.withdraw(amount);
                destination.deposit(amount);
            }
            System.out.println("UnLocked destination");
        }
        System.out.println("UnLocked source");

        System.out.println("Transfer after. Amount: " + amount);
        System.out.println("Source:" + source);
        System.out.println("Destination:" + destination);
    }

}
