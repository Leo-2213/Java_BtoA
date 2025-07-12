package com.learning301.designpatttern.BehaviouralPattern.MediatorPattern.WithoutPattern;

/**
 * User - WITHOUT Mediator Pattern
 * 
 * Problems with this approach:
 * 1. TIGHT COUPLING - Users must know about each other directly
 * 2. DIRECT COMMUNICATION - No centralized control
 * 3. HARD TO EXTEND - Adding features like group chat is difficult
 * 4. NO BROADCAST - Can only send to one user at a time
 * 5. MAINTENANCE ISSUES - Changes affect multiple classes
 */
public class User {
    private String name;

    /**
     * Constructor - User only needs name, no mediator reference
     */
    public User(String name){
        this.name = name;
    }

    /**
     * PROBLEMATIC METHOD - Direct communication between users
     * 
     * Issues:
     * - User must have direct reference to other users
     * - No centralized control over communication
     * - Cannot easily implement group messaging
     * - Hard to add features like message logging, filtering
     */
    public void sendMessage(String msg, User user) { // Fixed typo
        System.out.println(this.name + " sends a message: " + msg + " to " + user.getName());
    }

    /**
     * Get user name - should be public for other users to access
     */
    public String getName() { // Changed from private to public
        return this.name;
    }
}
