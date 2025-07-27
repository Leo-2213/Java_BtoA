package com.learning301.designpatttern.CreationalDesignPattern.PrototypePattern.WithPattern;

/**
 * GamePiece - Concrete Prototype
 * 
 * Implements ProtoType interface to support cloning
 * Represents a simple game piece with position and color
 * Demonstrates shallow cloning for objects with primitive/immutable fields
 * 
 * Prototype Pattern benefits:
 * - Can create copies without knowing exact class
 * - Avoids complex initialization logic
 * - Runtime object creation based on existing instances
 */
public class GamePiece implements ProtoType<GamePiece> {
    private int position;    // Game piece position on board
    private String color;    // Game piece color

    /**
     * Constructor for creating new game piece
     * 
     * @param position initial position on game board
     * @param color color of the game piece
     */
    public GamePiece(int position, String color){
        this.position = position;
        this.color = color;
    }

    /**
     * Get current position of game piece
     * @return current position
     */
    public int getPosition() {
        return position;
    }

    /**
     * Set new position for game piece
     * @param position new position on board
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Get color of game piece
     * @return piece color
     */
    public String getColor() {
        return color;
    }

    /**
     * Set new color for game piece
     * @param color new color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * String representation of game piece
     * Used for displaying piece state
     */
    @Override
    public String toString() {
        return "GamePiece{" +
                "position=" + position +
                ", color='" + color + '\'' +
                '}';
    }

    /**
     * Clone method - Creates exact copy of this GamePiece
     * 
     * Implements Prototype Pattern cloning
     * Creates new instance with same position and color
     * Since position (int) and color (String) are primitive/immutable,
     * this is effectively a deep clone
     * 
     * @return new GamePiece with identical state
     */
    @Override
    public GamePiece clone() {
        // Create new instance with same values
        // No need for deep cloning since fields are primitive/immutable
        return new GamePiece(this.position, this.color);
    }
}
