package MultiThreading;

// Thread-safe counter using synchronized method
class SynchronizedCounter {
    int count;
    
    public synchronized void increment() { // Only one thread can execute this at a time
        count++;
    }
    
    public int getCount() {
        return count;
    }
}

// Non-thread-safe counter - race conditions possible
class Counter {
    int count;
    
    public void increment() { // Multiple threads can execute simultaneously
        count++; // This operation is not atomic
    }
    
    public int getCount() {
        return count;
    }
}

// Thread that uses non-synchronized counter
class MyThread extends Thread {
    Counter counter;
    
    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment(); // Race condition possible
        }
    }
}

// Thread that uses synchronized counter
class SynchronizedMyThread extends Thread {
    SynchronizedCounter counter;
    
    public SynchronizedMyThread(SynchronizedCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment(); // Thread-safe operation
        }
    }
}




public class ThreadController {
    public static void main(String[] args) {
        // Test 1: Non-synchronized method (race conditions expected)
        System.out.println("=== NON-SYNCHRONIZED METHOD TEST ===");
        Counter counter = new Counter();
        Thread t1 = new MyThread(counter);
        Thread t2 = new MyThread(counter);

        t1.start();
        t2.start();

        try {
            t1.join(); // Wait for threads to complete
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Non-synchronized result: " + counter.getCount() + " (Expected: 2000)");
        System.out.println("Race condition occurred: " + (counter.getCount() < 2000));

        // Test 2: Synchronized method (thread-safe)
        System.out.println("\n=== SYNCHRONIZED METHOD TEST ===");
        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
        SynchronizedMyThread t3 = new SynchronizedMyThread(synchronizedCounter);
        SynchronizedMyThread t4 = new SynchronizedMyThread(synchronizedCounter);

        t3.start();
        t4.start();

        try {
            t3.join(); // Wait for threads to complete
            t4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Synchronized result: " + synchronizedCounter.getCount() + " (Expected: 2000)");
        System.out.println("Thread-safe: " + (synchronizedCounter.getCount() == 2000));
    }
}
