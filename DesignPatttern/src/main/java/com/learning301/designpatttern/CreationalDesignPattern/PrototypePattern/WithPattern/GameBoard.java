package com.learning301.designpatttern.CreationalDesignPattern.PrototypePattern.WithPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * GameBoard - Complex Concrete Prototype
 * 
 * Implements ProtoType interface with deep cloning capability
 * Contains collection of GamePiece objects
 * Demonstrates deep cloning for complex object graphs
 * 
 * Key Prototype Pattern features:
 * - Deep cloning of contained objects
 * - Preserves complex object relationships
 * - Avoids expensive reconstruction of game state
 */
public class GameBoard implements ProtoType<GameBoard>{

    // Collection of game pieces - requires deep cloning
    private List<GamePiece> pieces = new ArrayList<>();

    /**
     * Add a game piece to the board
     * 
     * @param piece the game piece to add
     */
    public void addPiece(GamePiece piece){
        pieces.add(piece);
    }

    /**
     * Get all pieces on the board
     * 
     * @return list of all game pieces
     */
    public List<GamePiece> getAllPieces(){
        return pieces;
    }

    /**
     * Display current state of all pieces on board
     * Useful for debugging and demonstration
     */
    public void showCurrentState(){
        System.out.println("Current board state:");
        if (pieces.isEmpty()) {
            System.out.println("  No pieces on board");
        } else {
            for (GamePiece piece: pieces){
                System.out.println("  " + piece);
            }
        }
        System.out.println();
    }

    /**
     * Clone method - Creates deep copy of entire GameBoard
     * 
     * DEEP CLONING IMPLEMENTATION:
     * - Creates new GameBoard instance
     * - Clones each GamePiece individually
     * - Ensures complete independence between original and clone
     * 
     * This is crucial for Prototype Pattern with complex objects:
     * - Modifying pieces in original won't affect clone
     * - Modifying pieces in clone won't affect original
     * - Each board maintains its own piece collection
     * 
     * @return new GameBoard with cloned pieces
     */
    @Override
    public GameBoard clone() {
        // Create new board instance
        GameBoard clonedBoard = new GameBoard();
        
        // Deep clone: clone each piece individually
        for (GamePiece piece: pieces){
            clonedBoard.addPiece(piece.clone()); // Clone each piece
        }
        
        return clonedBoard;
    }
}
