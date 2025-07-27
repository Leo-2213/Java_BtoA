package com.learning301.designpatttern.CreationalDesignPattern.PrototypePattern.WithoutPattern;

/**
 * GamePiece - WITHOUT Prototype Pattern
 * 
 * Problems:
 * - No standardized cloning mechanism
 * - Client must know internal structure to copy
 * - Manual copying is error-prone
 * - No clone() method available
 */
public class GamePiece {
    int position;
    String color;

    /**
     * Constructor for creating game piece
     */
    public GamePiece(int position, String color){
        this.position = position;
        this.color = color;
    }

    /**
     * Get position - needed for manual copying
     */
    public int getPosition() {
        return position;
    }

    /**
     * Set position
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Get color - needed for manual copying
     */
    public String getColor() {
        return color;
    }

    /**
     * Set color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * String representation
     */
    @Override
    public String toString() {
        return "GamePiece{" +
                "position=" + position +
                ", color='" + color + '\'' +
                '}';
    }
    
    // MISSING: No clone() method
    // Client must manually create copies using constructor
    // This is error-prone and requires knowledge of internal structure
}
