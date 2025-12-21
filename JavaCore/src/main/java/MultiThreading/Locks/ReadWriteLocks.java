package MultiThreading.Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Demonstrates ReadWriteLocks: allows multiple concurrent reads but exclusive writes
 * Key benefit: Better performance when reads are more frequent than writes
 */
public class ReadWriteLocks {

    static class RWLocks{
        private int count = 0;
        // Main ReadWriteLock - manages both read and write locks
        private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        // Read lock - multiple threads can hold this simultaneously
        private final Lock readLock = rwLock.readLock();
        // Write lock - only one thread can hold this (blocks all reads/writes)
        private final Lock writeLock = rwLock.writeLock();

        // Write operation - requires exclusive access
        public void increment(){
            writeLock.lock(); // Blocks all other reads and writes
            try{
                count++; // Modify shared data
            } finally {
                writeLock.unlock(); // Always release lock
            }
        }

        // Read operation - allows concurrent access with other reads
        public int getCount(){
            readLock.lock(); // Multiple threads can hold read lock together
            try {
                return count; // Read shared data safely
            }finally {
                readLock.unlock(); // Always release lock
            }
        }

    }

    public static void main(String[] args) {
        RWLocks rwLocks = new RWLocks();

        // Task that only reads - can run concurrently with other read tasks
        Runnable readTask = new Runnable() {
            @Override
            public void run() {
              for (int i = 0; i < 5; i++) {
                  System.out.println(Thread.currentThread().getName() + " read: " + rwLocks.getCount());
                  try { Thread.sleep(100); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
              }
            }
        };

        // Task that writes - must run exclusively (no other reads/writes allowed)
        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 5; i++) {
                    rwLocks.increment();
                    System.out.println(Thread.currentThread().getName() + ": incremented");
                }
            }
        };

        // Create threads: 2 readers + 1 writer
        Thread t1 = new Thread(readTask, "ReadThread 1");
        Thread t2 = new Thread(writeTask, "WriteThread 2");
        Thread t3 = new Thread(readTask, "ReadThread 3");

        // Start all threads - observe that read threads can run together
        t1.start();
        t2.start();
        t3.start();

        // Wait for all threads to complete
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final count: " + rwLocks.getCount());
    }
}

/*
 * Key Points:
 * 1. ReadWriteLock allows multiple concurrent READS but exclusive WRITES
 * 2. When a write lock is held, no reads or writes are allowed
 * 3. When read locks are held, other reads can proceed but writes must wait
 * 4. Best for scenarios with frequent reads and infrequent writes
 * 5. Improves performance compared to using a single synchronized block
 */