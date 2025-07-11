package com.learning301.designpatttern.BehaviouralPattern.CommandPattern.WithPattern;

/**
 * Concrete Command - BoldCommand
 * Encapsulates the bold text operation as a command object
 * Holds reference to the receiver (TextEditor) and calls appropriate method
 */
public class BoldCommand implements Command{

    // Receiver - the object that knows how to perform the operation
    private TextEditor textEditor;

    /**
     * Constructor - binds the command to a specific receiver
     * @param textEditor the receiver that will perform the actual work
     */
    public BoldCommand(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    /**
     * Execute method - delegates the actual work to the receiver
     * This is where the command pattern shines - decoupling invoker from receiver
     */
    @Override
    public void execute() {
        textEditor.boldText(); // Delegate to receiver
    }
}
