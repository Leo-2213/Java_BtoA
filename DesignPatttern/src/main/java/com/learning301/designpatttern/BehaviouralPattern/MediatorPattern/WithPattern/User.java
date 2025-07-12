package com.learning301.designpatttern.BehaviouralPattern.MediatorPattern.WithPattern;

/**
 * User - Colleague Class in Mediator Pattern
 * 
 * Represents individual participants in the chat system
 * Communicates with other users through the mediator, not directly
 * Maintains reference to mediator for sending messages
 * Receives messages from mediator when others send to them
 */
public class User {
    private String name;
    private ChatMediator chatMediator; // Reference to mediator

    /**
     * Constructor - User must be associated with a mediator
     * @param name user's name
     * @param chatMediator the mediator that handles communication
     */
    public User(String name, ChatMediator chatMediator){
        this.name = name;
        this.chatMediator = chatMediator;
    }

    /**
     * Get user's name
     * @return user name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Send message through mediator
     * User doesn't send directly to other users
     * Mediator handles the distribution
     */
    public void sendMessage(String msg) {
        chatMediator.broadcast(this, msg);
    }

    /**
     * Receive message from mediator
     * Called by mediator when another user sends a message
     */
    public void receiveMessage(String msg) {
        System.out.println(this.name + " received message: " + msg);
    }
}
