package com.learning301.designpatttern.BehaviouralPattern.CommandPattern.WithoutPattern;

/**
 * BoldButton - Tightly coupled to TextEditor
 * 
 * Problems:
 * - Directly depends on TextEditor (tight coupling)
 * - Cannot be reused with other receivers
 * - Hard to test in isolation
 * - Cannot change behavior at runtime
 * - Code duplication across similar button classes
 */
public class BoldButton {

    // Direct reference to TextEditor - tight coupling
    TextEditor textEditor;

    /**
     * Constructor binds button to specific TextEditor instance
     * Cannot work with other types of editors or receivers
     */
    public BoldButton(TextEditor textEditor){
        this.textEditor = textEditor;
    }
    
    /**
     * onClick directly calls TextEditor method
     * No abstraction layer - button knows too much about receiver
     */
    public void onClick(){
        textEditor.boldText(); // Direct method call - tight coupling
    }
}
