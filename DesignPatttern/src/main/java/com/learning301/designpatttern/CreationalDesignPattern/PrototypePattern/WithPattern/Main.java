package com.learning301.designpatttern.CreationalDesignPattern.PrototypePattern.WithPattern;

/**
 * Main - Client demonstrating Prototype Pattern
 * 
 * Shows how Prototype Pattern enables:
 * - Easy object cloning without knowing concrete classes
 * - Deep copying of complex object graphs
 * - Independent object instances after cloning
 * - Performance benefits over complex construction
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Prototype Pattern Demonstration ===");
        
        // Create original game board
        GameBoard originalBoard = new GameBoard();

        // Add game pieces to original board
        originalBoard.addPiece(new GamePiece(1, "red"));
        originalBoard.addPiece(new GamePiece(5, "purple"));
        originalBoard.addPiece(new GamePiece(3, "blue"));

        System.out.println("--- Original Board State ---");
        originalBoard.showCurrentState();

        // PROTOTYPE PATTERN: Clone the entire board
        // This creates a deep copy with all pieces cloned
        GameBoard clonedBoard = originalBoard.clone();

        System.out.println("--- Cloned Board State (immediately after cloning) ---");
        clonedBoard.showCurrentState();

        // Modify original board pieces to test independence
        System.out.println("--- Modifying Original Board Pieces ---");
        for(GamePiece piece: originalBoard.getAllPieces()){
            piece.setPosition(piece.getPosition() + 2); // Move each piece forward
        }

        System.out.println("--- Original Board After Modification ---");
        originalBoard.showCurrentState();

        System.out.println("--- Cloned Board (should be unchanged) ---");
        clonedBoard.showCurrentState();

        // Modify cloned board to further demonstrate independence
        System.out.println("--- Modifying Cloned Board Pieces ---");
        for(GamePiece piece: clonedBoard.getAllPieces()){
            piece.setColor("green"); // Change all pieces to green
        }

        System.out.println("--- Final State Comparison ---");
        System.out.println("Original Board:");
        originalBoard.showCurrentState();
        System.out.println("Cloned Board:");
        clonedBoard.showCurrentState();

        System.out.println("=== Prototype Pattern Benefits Demonstrated ===");
        System.out.println("✅ Easy cloning with .clone() method");
        System.out.println("✅ Deep copying - all pieces independently cloned");
        System.out.println("✅ Object independence - changes don't affect each other");
        System.out.println("✅ No need to know concrete classes for cloning");
        System.out.println("✅ Avoids complex reconstruction of game state");
    }
}
