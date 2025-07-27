package com.learning301.designpatttern.CreationalDesignPattern.PrototypePattern.WithoutPattern;

/**
 * Main - WITHOUT Prototype Pattern
 * 
 * Problems demonstrated:
 * 1. MANUAL COPYING - Client must manually copy each piece
 * 2. KNOWLEDGE REQUIRED - Client must know GamePiece constructor
 * 3. ERROR PRONE - Easy to forget fields or make mistakes
 * 4. VIOLATES ENCAPSULATION - Must access internal structure
 * 5. NOT SCALABLE - Adding fields requires updating copy code
 * 6. CODE DUPLICATION - Copy logic repeated wherever needed
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== WITHOUT Prototype Pattern ===");
        
        // Create original game board
        GameBoard originalBoard = new GameBoard();

        originalBoard.addPiece(new GamePiece(1, "red"));
        originalBoard.addPiece(new GamePiece(5, "purple"));

        System.out.println("--- Original Board ---");
        originalBoard.showCurrentState();

        // PROBLEMATIC MANUAL COPYING PROCESS
        System.out.println("--- Manual Copying Process ---");
        GameBoard copiedBoard = new GameBoard();
        
        // PROBLEM: Client must manually iterate and copy each piece
        // Must know GamePiece constructor signature
        // Must remember to copy ALL fields
        for (GamePiece piece: originalBoard.getAllPieces()){
            // Manual copying - error prone and requires internal knowledge
            copiedBoard.addPiece(new GamePiece(piece.getPosition(), piece.getColor()));
            // What if GamePiece had more fields? Easy to forget!
        }

        System.out.println("--- Manually Copied Board ---");
        copiedBoard.showCurrentState();

        // Test independence by modifying original
        System.out.println("--- Modifying Original Board ---");
        for(GamePiece piece: originalBoard.getAllPieces()){
            piece.setPosition(piece.getPosition() + 2);
        }

        System.out.println("--- Original Board After Modification ---");
        originalBoard.showCurrentState();
        
        System.out.println("--- Copied Board (should be unchanged) ---");
        copiedBoard.showCurrentState();

        System.out.println("\n=== Problems with this approach ===");
        System.out.println("❌ Manual copying is tedious and error-prone");
        System.out.println("❌ Client must know internal structure of objects");
        System.out.println("❌ Must remember to copy ALL fields");
        System.out.println("❌ Violates encapsulation - exposes internals");
        System.out.println("❌ Code duplication - copy logic repeated everywhere");
        System.out.println("❌ Not scalable - adding fields breaks copy code");
        System.out.println("❌ No standardized copying mechanism");
        
        System.out.println("\n--- What if GamePiece had more fields? ---");
        System.out.println("Current: new GamePiece(piece.getPosition(), piece.getColor())");
        System.out.println("With more fields: new GamePiece(pos, color, size, type, owner, ...)");
        System.out.println("Manual copying becomes unmanageable!");
    }
}
