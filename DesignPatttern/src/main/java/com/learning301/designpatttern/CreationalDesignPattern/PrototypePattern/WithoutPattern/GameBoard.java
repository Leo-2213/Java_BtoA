package com.learning301.designpatttern.CreationalDesignPattern.PrototypePattern.WithoutPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * GameBoard - WITHOUT Prototype Pattern
 * 
 * Problems:
 * - No clone() method for easy copying
 * - Client must manually copy all pieces
 * - Exposes internal structure for copying
 * - Error-prone manual deep copying process
 * - No standardized copying mechanism
 */
public class GameBoard {

    // Internal board structure exposed for manual copying
    List<GamePiece> board = new ArrayList<>();

    /**
     * Add piece to board
     */
    public void addPiece(GamePiece piece){
        board.add(piece);
    }

    /**
     * Get all pieces - PROBLEM: Exposes internal structure
     * Client needs this to manually copy pieces
     * Violates encapsulation principle
     */
    public List<GamePiece> getAllPieces(){
        return board; // Direct access to internal list
    }

    /**
     * Show current board state
     */
    public void showCurrentState(){
        System.out.println("Current board state:");
        if (board.isEmpty()) {
            System.out.println("  No pieces on board");
        } else {
            for (GamePiece piece: board){
                System.out.println("  " + piece);
            }
        }
        System.out.println();
    }
    
    // MISSING: No clone() method
    // Client must manually iterate through pieces and copy each one
    // This is complex, error-prone, and violates encapsulation
}
