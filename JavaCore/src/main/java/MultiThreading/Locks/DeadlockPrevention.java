package MultiThreading.Locks;

/**
 * Deadlock Prevention: Fixed Pen and Paper Scenario
 * Shows how to prevent deadlock by acquiring locks in consistent order
 */
public class DeadlockPrevention {
    
    private static final Object pen = new Object();
    private static final Object paper = new Object();
    
    public static void main(String[] args) {
        
        // Alice's task: gets pen first, then paper (SAME ORDER)
        Thread alice = new Thread(() -> {
            synchronized (pen) {  // Always get pen first
                System.out.println("Alice: I have the pen!");
                
                synchronized (paper) {  // Then get paper
                    System.out.println("Alice: Got both! Writing assignment...");
                    try { Thread.sleep(1000); } catch (InterruptedException e) {}
                    System.out.println("Alice: Assignment complete!");
                }
            }
        }, "Alice");
        
        // Bob's task: ALSO gets pen first, then paper (SAME ORDER)
        Thread bob = new Thread(() -> {
            synchronized (pen) {  // Always get pen first (waits for Alice)
                System.out.println("Bob: I have the pen!");
                
                synchronized (paper) {  // Then get paper
                    System.out.println("Bob: Got both! Writing assignment...");
                    try { Thread.sleep(1000); } catch (InterruptedException e) {}
                    System.out.println("Bob: Assignment complete!");
                }
            }
        }, "Bob");
        
        alice.start();
        bob.start();
        
        try {
            alice.join();
            bob.join();
            System.out.println("\n=== SUCCESS! No deadlock occurred ===");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

/*
 * KEY INSIGHT: Deadlock Prevention
 * 
 * PROBLEM: Different lock ordering
 * - Alice: pen → paper
 * - Bob: paper → pen
 * 
 * SOLUTION: Same lock ordering
 * - Alice: pen → paper  
 * - Bob: pen → paper (waits for Alice to finish)
 * 
 * This creates a queue instead of circular waiting!
 */