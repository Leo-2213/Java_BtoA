package com.learning301.designpatttern.BehaviouralPattern.MementoPattern;

/**
 * TextEditor - The Originator class in the Memento pattern
 * This class represents the object whose state needs to be saved and restored.
 * It creates mementos containing snapshots of its current state and uses
 * mementos to restore its state.
 */
public class TextEditor {
    // The state that will be saved and restored
    private String content;

    /**
     * Updates the content of the text editor
     * @param content The new content to be set
     */
    public void writeContent(String content){
        this.content = content;
    }

    /**
     * Gets the current content of the text editor
     * @return The current content
     */
    public String getContent(){
        return content;
    }

   /**
    * Creates a memento containing a snapshot of the current state
    * @return A new EditorMemento object with the current content
    */
   public EditorMemento save(){
        return new EditorMemento(content);
   }

   /**
    * Restores the text editor's state from a memento object
    * @param memento The memento object containing the state to restore
    */
   public void restore(EditorMemento memento){
        content = memento.getContent();
   }
}
