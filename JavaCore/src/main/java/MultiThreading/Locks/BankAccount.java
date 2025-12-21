package MultiThreading.Locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.currentThread;

public class BankAccount {
    private int balance = 50000;

    // Synchronized method - only one thread can execute at a time
    // Other threads block indefinitely until current thread finishes
    public synchronized void withdraw(int amount) throws InterruptedException {
        System.out.println("===Attempting Withdrawal===");
        if(amount > this.balance) {
            System.out.println("Insufficient balance");
            return;
        }else{
            this.balance -= amount;
            Thread.sleep(2000); // Simulates database operation delay
            System.out.println("Amount withdrawal :" + amount + "           Balance left: " + this.balance);
            System.out.println("Current Thread:   "+ currentThread().getName());
            System.out.println("===Withdrawal successful.===");
        }
    }

    // Custom ReentrantLock - provides more control than synchronized
    Lock lock = new ReentrantLock();
    
    public void customWithdrawal(int amount) throws InterruptedException {
        System.out.println("===Attempting Custom Withdrawal===");

        try {
                // Try to acquire lock with 5-second timeout
                // Returns false if lock not available within timeout
                if(lock.tryLock(5, TimeUnit.SECONDS)){
                    if(amount <= this.balance) {
                        try {
                            this.balance -= amount;
                            Thread.sleep(2000); // Simulates database operation delay
                            System.out.println("Amount withdrawal :" + amount + "           Balance left: " + this.balance);
                            System.out.println("Current Thread:   "+ currentThread().getName());
                            System.out.println("===Withdrawal successful.===");
                        }
                        catch (InterruptedException e) {
                            System.out.println(currentThread().getName() + "Interrupted while having a lock");
                            currentThread().interrupt();
                        }
                        finally {
                            lock.unlock(); // Always release lock in finally block
                        }

                    }else{
                        System.out.println("Insufficient Amount");
                    }
                }
                else {
                    // Lock timeout - thread gives up and continues
                    System.out.println(currentThread().getName() + " Lock acquired, Will try after some time.");
                }
        }catch (InterruptedException e){
            currentThread().interrupt();
        }
    }

}
