package com.learning301.designpatttern.BehaviouralPattern.MediatorPattern.WithoutPattern;

/**
 * Chat - WITHOUT Mediator Pattern
 * 
 * Problems demonstrated:
 * 1. TIGHT COUPLING - Users communicate directly with each other
 * 2. NO CENTRALIZED CONTROL - No single point to manage communication
 * 3. REPETITIVE CODE - Must send same message to multiple users separately
 * 4. HARD TO EXTEND - Adding group features requires major changes
 * 5. NO BROADCAST - Cannot send to all users at once
 */
public class Chat {
    public static void main(String[] args) {
        System.out.println("=== WITHOUT Mediator Pattern ===");
        
        // Create users independently
        User abhi = new User("Abhi");
        User rahul = new User("Rahul");
        User abhishek = new User("Abhishek");

        System.out.println("\n--- Direct Communication Problems ---");
        // PROBLEM: Must send to each user individually
        // No way to broadcast to all users at once
        abhi.sendMessage("hey wassup", rahul);    // Fixed typo
        abhi.sendMessage("hey wassup", abhishek); // Fixed typo
        
        System.out.println("\n--- Problems with this approach ---");
        System.out.println("✗ Users must know about each other directly");
        System.out.println("✗ No centralized communication control");
        System.out.println("✗ Must send same message multiple times");
        System.out.println("✗ Hard to implement group chat features");
        System.out.println("✗ Cannot easily add message logging or filtering");
    }
}
