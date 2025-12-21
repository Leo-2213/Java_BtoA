/*
 * FAIR vs NON-FAIR LOCKS DEMONSTRATION
 * 
 * FAIR LOCK:
 * - Ensures FIFO (First-In-First-Out) ordering
 * - Threads acquire lock in the order they requested it
 * - Prevents thread starvation
 * - Lower performance due to overhead of maintaining order
 * - Constructor: new ReentrantLock(true)
 * 
 * NON-FAIR LOCK (Default):
 * - Any waiting thread can acquire the lock when available
 * - No guarantee about order of lock acquisition
 * - Better performance due to less overhead
 * - Can lead to thread starvation
 * - Constructor: new ReentrantLock() or new ReentrantLock(false)
 * 
 * WHEN TO USE:
 * Fair Lock: When predictable execution order is critical, fairness over performance
 * Non-Fair Lock: Default choice for most applications, performance over fairness
 */
package MultiThreading.Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairVsNonFairDemo {
    static class FairLockTask {
        private final Lock fairLock = new ReentrantLock(true); // Fair lock

        public void accessResource() {
            fairLock.lock();
            try {
                System.out.println("FAIR - Thread: " + Thread.currentThread().getName() + " acquired lock");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                System.out.println("FAIR - Thread: " + Thread.currentThread().getName() + " released lock");
                fairLock.unlock();
            }
        }
    }

    static class NonFairLockTask {
        private final Lock nonFairLock = new ReentrantLock(false); // Non-fair lock

        public void accessResource() {
            nonFairLock.lock();
            try {
                System.out.println("NON-FAIR - Thread: " + Thread.currentThread().getName() + " acquired lock");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                System.out.println("NON-FAIR - Thread: " + Thread.currentThread().getName() + " released lock");
                nonFairLock.unlock();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== FAIR LOCK DEMO ===");
        FairLockTask fairTask = new FairLockTask();
        
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> fairTask.accessResource(), "FairThread-" + i).start();
        }
        
        Thread.sleep(2000);
        
        System.out.println("\n=== NON-FAIR LOCK DEMO ===");
        NonFairLockTask nonFairTask = new NonFairLockTask();
        
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> nonFairTask.accessResource(), "NonFairThread-" + i).start();
        }
    }
}