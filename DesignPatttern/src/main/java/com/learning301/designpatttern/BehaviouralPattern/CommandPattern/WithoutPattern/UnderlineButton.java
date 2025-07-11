package com.learning301.designpatttern.BehaviouralPattern.CommandPattern.WithoutPattern;

/**
 * UnderlineButton - Third repetition of the same pattern
 * 
 * Problems:
 * - Exact same structure as Bold and Italic buttons
 * - Demonstrates poor scalability - imagine 20+ formatting options!
 * - Each button class needs separate maintenance
 * - Cannot combine operations or create macro commands
 * - No way to implement undo/redo functionality
 */
public class UnderlineButton {

    // Identical field declaration - third time!
    TextEditor textEditor;

    /**
     * Identical constructor pattern - copy-paste programming
     */
    public UnderlineButton(TextEditor textEditor){
        this.textEditor = textEditor;
    }
    
    /**
     * Same onClick structure - only method call differs
     * This approach doesn't scale well for complex applications
     */
    public void onClick(){
        textEditor.underlineText(); // Direct coupling continues
    }
}
