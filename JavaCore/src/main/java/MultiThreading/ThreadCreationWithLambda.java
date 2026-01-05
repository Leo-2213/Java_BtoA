package MultiThreading;

/**
 * Demonstrates different ways to create threads using lambda expressions.
 * Shows the evolution from anonymous inner classes to lambda expressions.
 */
public class ThreadCreationWithLambda {
    public static void main(String[] args) {
        
        // Method 1: Traditional approach using anonymous inner class
        // This is the old way of implementing Runnable interface
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 (Anonymous class): " + Thread.currentThread().getName());
            }
        };
        Thread thread1 = new Thread(runnable1, "Thread-1");
        thread1.start();
        
        // Method 2: Lambda expression with block body
        // Since Runnable is a functional interface (has only one abstract method),
        // we can replace the anonymous class with a lambda expression
        Runnable runnable2 = () -> {
            System.out.println("Thread 2 (Lambda block): " + Thread.currentThread().getName());
            // Multiple statements can be added here
        };
        Thread thread2 = new Thread(runnable2, "Thread-2");
        thread2.start();
        
        // Method 3: Lambda expression with single statement (most concise)
        // For single statements, we can omit the curly braces
        Thread thread3 = new Thread(() -> 
            System.out.println("Thread 3 (Lambda inline): " + Thread.currentThread().getName()), 
            "Thread-3"
        );
        thread3.start();
        
        // Method 4: Lambda with method reference (when applicable)
        // If we have a method that matches the signature, we can use method reference
        Thread thread4 = new Thread(ThreadCreationWithLambda::printThreadInfo, "Thread-4");
        thread4.start();
        
        // Main thread info
        System.out.println("Main thread: " + Thread.currentThread().getName());
    }
    
    /**
     * Helper method to demonstrate method reference usage
     */
    private static void printThreadInfo() {
        System.out.println("Thread 4 (Method reference): " + Thread.currentThread().getName());
    }
}
