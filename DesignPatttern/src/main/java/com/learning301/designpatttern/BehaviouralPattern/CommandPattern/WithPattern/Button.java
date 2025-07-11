package com.learning301.designpatttern.BehaviouralPattern.CommandPattern.WithPattern;

/**
 * Invoker - Button class
 * Holds a reference to a command and can trigger it
 * Doesn't know what the command does - maintains loose coupling
 * Can be configured with different commands at runtime
 */
public class Button {
    // Reference to command - can be changed at runtime
    private Command command;

    /**
     * Set the command to be executed when button is clicked
     * This allows runtime configuration of button behavior
     * @param command the command to execute
     */
    public void setCommand(Command command){
        this.command = command;
    }
    
    /**
     * Trigger the command execution
     * Button doesn't know what command does - just calls execute()
     * This is the key benefit of Command Pattern - decoupling
     */
    public void click(){
        if (command != null) {
            command.execute();
        }
    }
}
