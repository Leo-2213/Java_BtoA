package com.learning301.designpatttern.BehaviouralPattern.CommandPattern.WithPattern;

/**
 * Concrete Command - ItalicCommand
 * Encapsulates the italic text operation as a command object
 * Holds reference to the receiver (TextEditor) and calls appropriate method
 */
public class ItalicCommand implements Command{

    // Receiver - the object that knows how to perform the operation
    private TextEditor textEditor;

    /**
     * Constructor - binds the command to a specific receiver
     * @param textEditor the receiver that will perform the actual work
     */
    public ItalicCommand(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    /**
     * Execute method - delegates the actual work to the receiver
     * This maintains loose coupling between invoker and receiver
     */
    @Override
    public void execute() {
        textEditor.italicText(); // Delegate to receiver
    }
}
