package com.learning301.designpatttern.BehaviouralPattern.MementoPattern;

/**
 * Main - Client class that demonstrates the Memento pattern
 * This class shows how the TextEditor (Originator), EditorMemento (Memento),
 * and CareTaker work together to save and restore states.
 */
public class Main {
    public static void main(String[] args) {

        // Create the originator (TextEditor) and caretaker objects
        TextEditor textEditor = new TextEditor();
        CareTaker careTaker = new CareTaker();

        // Set initial content and save its state
        textEditor.writeContent("initial content");
        careTaker.saveState(textEditor);
        
        // Update content and save the new state
        textEditor.writeContent("updated content");
        careTaker.saveState(textEditor);

        // Undo to restore to the previous state (should go back to "initial content")
        careTaker.undo(textEditor);
        // Uncomment to undo again (would need proper handling if history becomes empty)
        // careTaker.undo(textEditor);

        // Display the current content after undo
        System.out.println("Current content: " + textEditor.getContent());
    }
}
