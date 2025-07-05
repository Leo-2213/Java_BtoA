package com.learning301.designpatttern.BehaviouralPattern.MementoPattern;

import java.util.Stack;

/**
 * CareTaker - The Caretaker class in the Memento pattern
 * This class is responsible for keeping track of multiple memento objects.
 * It stores the history of states and provides methods to save new states
 * and restore previous states without exposing the memento's implementation details.
 */
public class CareTaker {

    // Stack to store the history of editor states
    private Stack<EditorMemento> history = new Stack<>();

    /**
     * Saves the current state of the editor by requesting a memento from it
     * and adding it to the history stack
     * @param editor The TextEditor whose state needs to be saved
     */
    public void saveState(TextEditor editor){
        history.push(editor.save());
    }

    /**
     * Restores the editor to its previous state
     * This method removes the current state from the stack and
     * restores the editor to the previous state
     * @param editor The TextEditor whose state needs to be restored
     */
    public void undo(TextEditor editor){
        if(!history.isEmpty()){
            // Remove the current state
            history.pop();
            // If there are previous states, restore to the most recent one
            if(!history.isEmpty()) {
                editor.restore(history.peek());
            }
        }
    }
}
