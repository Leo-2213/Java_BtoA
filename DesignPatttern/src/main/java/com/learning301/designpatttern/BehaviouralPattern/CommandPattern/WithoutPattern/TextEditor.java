package com.learning301.designpatttern.BehaviouralPattern.CommandPattern.WithoutPattern;

/**
 * TextEditor - The Receiver (same in both approaches)
 * 
 * Note: This class is identical in both WithPattern and WithoutPattern
 * The receiver doesn't change - only how it's invoked differs
 * 
 * In WithoutPattern: Buttons directly call these methods (tight coupling)
 * In WithPattern: Commands encapsulate these calls (loose coupling)
 */
public class TextEditor {

    /**
     * Bold text operation - actual business logic
     */
    public void boldText(){
        System.out.println("Bold Text");
    }

    /**
     * Italic text operation - actual business logic
     */
    public void italicText(){
        System.out.println("Italic Text");
    }

    /**
     * Underline text operation - actual business logic
     */
    public void underlineText(){
        System.out.println("Underline Text");
    }
}
