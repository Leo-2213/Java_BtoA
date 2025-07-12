package com.learning301.designpatttern.BehaviouralPattern.MediatorPattern.WithPattern;

/**
 * ChatRoom - Client demonstrating Mediator Pattern
 * 
 * Shows how mediator pattern enables communication between objects
 * without them having direct references to each other
 * Demonstrates centralized communication control through mediator
 */
public class ChatRoom {
    public static void main(String[] args) {
        System.out.println("=== Mediator Pattern Demonstration ===");
        
        // Create concrete mediator
        ChatMediator whatsApp = new Whatsapp();

        // Create users (colleagues) with reference to mediator
        User abhi = new User("Abhi", whatsApp);
        User rahul = new User("Rahul", whatsApp);
        User rohit = new User("Rohit", whatsApp);

        // Add users to the mediator's managed group
        whatsApp.addUser(abhi);
        whatsApp.addUser(rahul);
        whatsApp.addUser(rohit);

        System.out.println("\n--- Broadcasting Messages ---");
        // Users communicate through mediator, not directly
        whatsApp.broadcast(abhi, "Hello All");
        whatsApp.broadcast(rohit, "Hello Everyone");
        
        System.out.println("\n--- Alternative: Users can also send directly ---");
        // Users can also send through their own sendMessage method
        abhi.sendMessage("How is everyone doing?");
        rahul.sendMessage("Great! Thanks for asking.");
    }
}
