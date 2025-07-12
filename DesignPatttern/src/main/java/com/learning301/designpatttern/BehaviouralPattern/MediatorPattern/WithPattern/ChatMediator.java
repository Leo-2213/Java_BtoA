package com.learning301.designpatttern.BehaviouralPattern.MediatorPattern.WithPattern;

/**
 * ChatMediator Interface - Mediator Pattern Core
 * 
 * Defines the contract for communication between colleagues (users)
 * Encapsulates how objects interact with each other
 * Promotes loose coupling by preventing direct references between colleagues
 */
public interface ChatMediator {
    /**
     * Add a user to the chat system
     * @param user the user to be added
     */
    void addUser(User user);
    
    /**
     * Broadcast message from sender to all other users
     * @param user the sender of the message
     * @param msg the message to broadcast
     */
    void broadcast(User user, String msg);
}
