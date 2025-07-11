package com.learning301.designpatttern.BehaviouralPattern.CommandPattern.WithPattern;

/**
 * Client - Main class demonstrating Command Pattern
 * 
 * Command Pattern Components:
 * 1. Command Interface - defines execute() method
 * 2. Concrete Commands - BoldCommand, ItalicCommand (encapsulate operations)
 * 3. Receiver - TextEditor (knows how to perform operations)
 * 4. Invoker - Button (triggers commands without knowing details)
 * 5. Client - Main (creates and configures commands)
 * 
 * Benefits:
 * - Decouples invoker from receiver
 * - Commands can be stored, queued, logged, undone
 * - Easy to add new commands without changing existing code
 * - Runtime configuration of behavior
 */
public class Main {
    public static void main(String[] args) {
        // Create receiver - knows how to perform actual operations
        TextEditor textEditor = new TextEditor();

        // Create invoker - will trigger commands
        Button button = new Button();

        // Create and configure command for bold operation
        // Command encapsulates the request and binds it to receiver
        button.setCommand(new BoldCommand(textEditor));
        button.click(); // Invoker triggers command execution

        // Runtime reconfiguration - same button, different command
        // This demonstrates the flexibility of Command Pattern
        button.setCommand(new ItalicCommand(textEditor));
        button.click(); // Same invoker, different behavior
        
        // Could easily add more commands like:
        // button.setCommand(new UnderlineCommand(textEditor));
        // button.click();
    }
}
