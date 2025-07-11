package com.learning301.designpatttern.BehaviouralPattern.CommandPattern.WithPattern;

/**
 * Command Interface - Core of Command Pattern
 * Defines the contract that all concrete commands must follow
 * Encapsulates a request as an object
 */
public interface Command {
    /**
     * Execute the command - this method will be called by the invoker
     */
    public void execute();
}
