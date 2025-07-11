package com.learning301.designpatttern.BehaviouralPattern.CommandPattern.WithoutPattern;

/**
 * WITHOUT Command Pattern - Direct coupling approach
 * 
 * Problems with this approach:
 * 1. Tight coupling - Each button is tightly coupled to TextEditor
 * 2. Code duplication - Similar structure repeated in each button class
 * 3. Hard to extend - Adding new operations requires new button classes
 * 4. No flexibility - Cannot change button behavior at runtime
 * 5. No command queuing/logging/undo capabilities
 * 6. Violates Open/Closed Principle - Must modify code to add features
 */
public class Main {
    public static void main(String[] args) {
        // Create the receiver
        TextEditor textEditor = new TextEditor();
        
        // Create separate button classes for each operation
        // Each button is tightly coupled to TextEditor
        BoldButton boldButton = new BoldButton(textEditor);
        ItalicButton italicButton = new ItalicButton(textEditor);
        UnderlineButton underlineButton = new UnderlineButton(textEditor);

        // Each button can only do one specific operation
        // No runtime flexibility or behavior change possible
        boldButton.onClick();
        italicButton.onClick();
        underlineButton.onClick();
    }
}
