package MultiThreading.Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterruptibleLockExample {
    private static final Lock lock = new ReentrantLock();
    
    public static void main(String[] args) throws InterruptedException {
        
        // Thread 1: Holds the lock for a long time
        Thread lockHolder = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread1: Acquired lock, sleeping for 10 seconds...");
                Thread.sleep(10000); // Hold lock for 10 seconds
            } catch (InterruptedException e) {
                System.out.println("Thread1: Interrupted while holding lock");
            } finally {
                lock.unlock();
                System.out.println("Thread1: Released lock");
            }
        }, "LockHolder");
        
        // Thread 2: Tries to get lock using lockInterruptibly()
        Thread interruptibleWaiter = new Thread(() -> {
            try {
                System.out.println("Thread2: Trying to acquire lock interruptibly...");
                lock.lockInterruptibly(); // Can be interrupted while waiting
                try {
                    System.out.println("Thread2: Got the lock!");
                } finally {
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                System.out.println("Thread2: Was interrupted while waiting for lock!");
                // Handle interruption gracefully
            }
        }, "InterruptibleWaiter");
        
        // Thread 3: Tries to get lock using regular lock()
        Thread regularWaiter = new Thread(() -> {
            System.out.println("Thread3: Trying to acquire lock (non-interruptible)...");
            lock.lock(); // Cannot be interrupted
            try {
                System.out.println("Thread3: Got the lock!");
            } finally {
                lock.unlock();
            }
        }, "RegularWaiter");
        
        // Start all threads
        lockHolder.start();
        Thread.sleep(100); // Ensure lockHolder gets lock first
        
        interruptibleWaiter.start();
        regularWaiter.start();
        
        // Wait 2 seconds, then interrupt the interruptible waiter
        Thread.sleep(2000);
        System.out.println("Main: Interrupting interruptible waiter...");
        interruptibleWaiter.interrupt();
        
        // Wait for all threads to complete
        lockHolder.join();
        interruptibleWaiter.join();
        regularWaiter.join();
        
        System.out.println("All threads completed");
    }
}