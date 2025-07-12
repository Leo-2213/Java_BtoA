package com.learning301.designpatttern.BehaviouralPattern.MediatorPattern.WithPattern;

import java.util.List;

/**
 * Whatsapp - Concrete Mediator Implementation
 * 
 * Implements the ChatMediator interface
 * Manages communication between all users in the chat group
 * Maintains list of users and handles message broadcasting
 * Encapsulates the interaction logic between colleagues
 */
public class Whatsapp implements ChatMediator{

    // List of all users in the chat group
    private List<User> users;

    /**
     * Constructor - Initialize empty user list
     */
    public Whatsapp(){
        this.users = new java.util.ArrayList<>();
    }

    /**
     * Add user to the chat group
     * Mediator manages the collection of colleagues
     */
    public void addUser(User user){
        System.out.println("User: " + user.getName() + " is added to the group");
        users.add(user);
    }

    /**
     * Broadcast message from sender to all other users
     * This is the core mediator functionality - managing communication
     * Users don't communicate directly, mediator handles all interactions
     */
    @Override
    public void broadcast(User sender, String msg) {
        System.out.println(sender.getName() + " is sending a message to everyone.");
        
        // Send message to all users except the sender
        for(User user: users){
            if(!user.getName().equals(sender.getName())){ // Fixed string comparison
                System.out.println("Sending message to " + user.getName() + ": " + msg);
                user.receiveMessage(msg); // Fixed typo
            }
        }
        System.out.println();
    }
}