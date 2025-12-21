package MultiThreading.BasicOfMultithreading;

// Method 1: Extending Thread class
class MyThread extends Thread {
    private String threadName;
    
    public MyThread(String name) {
        this.threadName = name;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(threadName + " - Count: " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted");
            }
        }
        System.out.println(threadName + " finished");
    }
}

// Method 2: Implementing Runnable interface
class MyRunnable implements Runnable {
    private String taskName;
    
    public MyRunnable(String name) {
        this.taskName = name;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(taskName + " - Count: " + i);
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                System.out.println(taskName + " interrupted");
            }
        }
        System.out.println(taskName + " completed");
    }
}

public class BasicsOfMultiThreading {
    public static void main(String[] args) {
        System.out.println("=== THREAD CLASS EXAMPLE ===");
        
        // Creating thread by extending Thread class
        MyThread thread1 = new MyThread("Thread-1");
        thread1.setName("CustomThread-1");
        thread1.setPriority(Thread.MAX_PRIORITY);
        
        // Basic thread methods
        System.out.println("Thread Name: " + thread1.getName());
        System.out.println("Thread Priority: " + thread1.getPriority());
        System.out.println("Is Daemon: " + thread1.isDaemon());
        System.out.println("Thread State: " + thread1.getState());
        
        thread1.start(); // Start the thread
        
        System.out.println("\n=== RUNNABLE INTERFACE EXAMPLE ===");
        
        // Creating thread using Runnable interface
        MyRunnable task = new MyRunnable("Task-1");
        Thread thread2 = new Thread(task, "RunnableThread");
        thread2.setPriority(Thread.NORM_PRIORITY);
        
        System.out.println("Runnable Thread Name: " + thread2.getName());
        System.out.println("Runnable Thread Priority: " + thread2.getPriority());
        
        thread2.start();
        
        System.out.println("\n=== DAEMON THREAD EXAMPLE ===");
        
        // Daemon thread example
        Thread daemonThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Daemon working: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }, "DaemonThread");
        
        daemonThread.setDaemon(true); // Must be set before start()
        daemonThread.start();
        
        System.out.println("\n=== THREAD CONTROL METHODS ===");
        
        try {
            // Wait for threads to complete
            thread1.join(); // Main thread waits for thread1
            thread2.join(); // Main thread waits for thread2
            
            System.out.println("\nAll user threads completed");
            System.out.println("Main thread ending (daemon may still run briefly)");
            
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        
        // Current thread info
        Thread currentThread = Thread.currentThread();
        System.out.println("\nCurrent Thread: " + currentThread.getName());
        System.out.println("Active Threads: " + Thread.activeCount());
    }
}
