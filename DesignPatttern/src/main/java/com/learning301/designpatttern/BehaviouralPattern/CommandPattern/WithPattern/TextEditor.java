package com.learning301.designpatttern.BehaviouralPattern.CommandPattern.WithPattern;

/**
 * Receiver - TextEditor class
 * Contains the actual business logic for text formatting operations
 * Commands delegate their work to methods in this class
 * Knows how to perform the actual operations
 */
public class TextEditor {

    /**
     * Make text bold - actual implementation of bold operation
     */
    public void boldText(){
        System.out.println("Text formatted as Bold");
    }

    /**
     * Make text italic - actual implementation of italic operation
     */
    public void italicText(){
        System.out.println("Text formatted as Italic");
    }

    /**
     * Make text underlined - actual implementation of underline operation
     */
    public void underlineText(){
        System.out.println("Text formatted as Underlined");
    }
}
