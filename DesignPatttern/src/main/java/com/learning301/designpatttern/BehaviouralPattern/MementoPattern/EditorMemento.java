package com.learning301.designpatttern.BehaviouralPattern.MementoPattern;

/**
 * EditorMemento - The Memento class in the Memento pattern
 * This class stores the internal state of the TextEditor object.
 * It acts as a snapshot of the TextEditor's state at a particular point in time.
 * The memento object is opaque to all classes except the originator (TextEditor).
 */
public class EditorMemento {

    // The state that is stored in the memento
    private String content;

    /**
     * Constructor that takes the state to be stored
     * Package-private access level ensures only classes in the same package can create mementos
     * @param content The content to be stored in the memento
     */
    EditorMemento(String content){
        this.content = content;
    }

    /**
     * Returns the stored content
     * @return The content stored in this memento
     */
    public String getContent(){
        return content;
    }
}
