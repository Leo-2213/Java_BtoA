package MultiThreading.Locks;

/**
 * Deadlock Example: Pen and Paper Scenario
 * Shows how two threads can get stuck waiting for each other's resources
 */
public class DeadlockExample {
    
    // Shared resources - only one of each available
    private static final Object pen = new Object();
    private static final Object paper = new Object();
    
    public static void main(String[] args) {
        
        // Alice's task: needs pen first, then paper
        Thread alice = new Thread(() -> {
            synchronized (pen) {  // Alice gets the pen first
                System.out.println("Alice: I have the pen!");
                
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                
                System.out.println("Alice: Now I need paper...");
                synchronized (paper) {  // Alice waits for paper (Bob has it)
                    System.out.println("Alice: Got both! Writing assignment...");
                }
            }
        }, "Alice");
        
        // Bob's task: needs paper first, then pen  
        Thread bob = new Thread(() -> {
            synchronized (paper) {  // Bob gets the paper first
                System.out.println("Bob: I have the paper!");
                
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                
                System.out.println("Bob: Now I need pen...");
                synchronized (pen) {  // Bob waits for pen (Alice has it)
                    System.out.println("Bob: Got both! Writing assignment...");
                }
            }
        }, "Bob");
        
        // Start both threads - they will deadlock!
        alice.start();
        bob.start();
        
        // Wait a bit to see the deadlock
        try {
            Thread.sleep(2000);
            System.out.println("\n=== DEADLOCK DETECTED! ===");
            System.out.println("Alice has pen, waiting for paper");
            System.out.println("Bob has paper, waiting for pen");
            System.out.println("Both threads are stuck forever!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

/*
 * DEADLOCK CONDITIONS (all 4 must be present):
 * 1. Mutual Exclusion: Resources can't be shared (pen/paper)
 * 2. Hold and Wait: Thread holds one resource while waiting for another
 * 3. No Preemption: Resources can't be forcibly taken away
 * 4. Circular Wait: Thread A waits for Thread B, Thread B waits for Thread A
 * 
 * PREVENTION STRATEGIES:
 * 1. Always acquire locks in same order (both get pen first, then paper)
 * 2. Use timeout on lock acquisition
 * 3. Avoid nested locks when possible
 * 4. Use higher-level concurrency utilities (like java.util.concurrent)
 */