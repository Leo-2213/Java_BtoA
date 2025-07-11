package com.learning301.designpatttern.BehaviouralPattern.CommandPattern.WithoutPattern;

/**
 * ItalicButton - Almost identical to BoldButton
 * 
 * Problems:
 * - Code duplication (same structure as BoldButton)
 * - Violates DRY principle
 * - Each new operation requires a new button class
 * - Maintenance nightmare - changes need to be made in multiple places
 */
public class ItalicButton {

    // Same field as BoldButton - code duplication
    TextEditor textEditor;

    /**
     * Same constructor pattern as BoldButton - repetitive code
     */
    public ItalicButton(TextEditor textEditor){
        this.textEditor = textEditor;
    }
    
    /**
     * Same method structure as BoldButton, only method call differs
     * This repetition could be avoided with Command Pattern
     */
    public void onClick(){
        textEditor.italicText(); // Only this line differs from BoldButton
    }
}
