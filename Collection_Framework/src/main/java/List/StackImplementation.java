package List;

import java.util.*;

/*
 * STACK OVERVIEW:
 * - LIFO (Last In, First Out) data structure
 * - Extends Vector class (inherits synchronization and legacy issues)
 * - Adds stack-specific operations: push, pop, peek, empty, search
 * - Built on top of Vector's resizable array implementation
 * 
 * STRUCTURE: [bottom] elem0 -> elem1 -> elem2 -> ... -> elemN [top]
 * 
 * STACK OPERATIONS:
 * - push(item): Add to top - O(1) amortized
 * - pop(): Remove and return top - O(1)
 * - peek(): View top without removing - O(1)
 * - empty(): Check if stack is empty - O(1)
 * - search(item): Find position from top (1-based) - O(n)
 * 
 * PROS:
 * - Simple LIFO operations
 * - Thread-safe (inherits from Vector)
 * - Familiar stack interface
 * - Supports all Vector/List operations
 * 
 * CONS:
 * - Legacy design (extends Vector)
 * - Synchronization overhead
 * - Exposes Vector methods (breaks encapsulation)
 * - Not part of Collections Framework design
 * 
 * MODERN ALTERNATIVES:
 * - ArrayDeque (recommended for stack operations)
 * - LinkedList (as Deque)
 * - Custom stack implementation
 * 
 * WHEN TO USE:
 * - Legacy code compatibility
 * - Simple LIFO operations with thread safety
 * - When Vector features are also needed
 */
public class StackImplementation {
    public static void main(String[] args) {
        // Basic Stack Operations
        basicStackOperations();
        
        // Stack-specific methods
        stackSpecificMethods();
        
        // Stack use cases
        stackUseCases();
        
        // Modern alternatives
        modernAlternatives();
    }
    
    // Core LIFO operations - all O(1) except search
    private static void basicStackOperations() {
        System.out.println("=== Basic Stack Operations ===");
        Stack<Integer> stack = new Stack<>();
        
        // Push operations - O(1) amortized (add to top)
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        System.out.println("After pushes: " + stack);
        System.out.println("Stack grows from left to right (left=bottom, right=top)");
        
        // Peek operation - O(1) (view top without removing)
        int topElement = stack.peek();
        System.out.println("Peek (top element): " + topElement);
        System.out.println("Stack after peek: " + stack + " (unchanged)");
        
        // Pop operation - O(1) (remove and return top)
        int poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);
        System.out.println("Stack after pop: " + stack);
        
        // Check if empty - O(1)
        System.out.println("Is empty: " + stack.empty());
        System.out.println();
    }
    
    // Stack-specific methods and inherited Vector methods
    private static void stackSpecificMethods() {
        System.out.println("=== Stack Specific Methods ===");
        Stack<String> stack = new Stack<>();
        
        // Build stack
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        stack.push("Fourth");
        System.out.println("Stack: " + stack);
        
        // Search operation - O(n) returns 1-based position from top
        System.out.println("Search 'Third': " + stack.search("Third") + " (2nd from top)");
        System.out.println("Search 'First': " + stack.search("First") + " (4th from top)");
        System.out.println("Search 'NotFound': " + stack.search("NotFound") + " (-1 if not found)");
        
        // Inherited Vector methods (breaks stack encapsulation)
        System.out.println("\nInherited Vector methods (not recommended):");
        System.out.println("Element at index 0 (bottom): " + stack.get(0));
        System.out.println("Element at index 3 (top): " + stack.get(3));
        stack.add(1, "Inserted"); // Breaks LIFO principle
        System.out.println("After Vector.add(1, 'Inserted'): " + stack);
        System.out.println();
    }
    
    // Common stack use cases
    private static void stackUseCases() {
        System.out.println("=== Stack Use Cases ===");
        
        // 1. Parentheses matching
        System.out.println("1. Parentheses Matching:");
        System.out.println("   Expression: ((()))");
        System.out.println("   Use stack to match opening/closing brackets");
        
        // 2. Function call management
        System.out.println("\n2. Function Call Stack:");
        System.out.println("   main() -> methodA() -> methodB()");
        System.out.println("   Stack: [main, methodA, methodB] (methodB on top)");
        
        // 3. Undo operations
        Stack<String> undoStack = new Stack<>();
        undoStack.push("Action1");
        undoStack.push("Action2");
        undoStack.push("Action3");
        System.out.println("\n3. Undo Operations:");
        System.out.println("   Actions: " + undoStack);
        System.out.println("   Undo last: " + undoStack.pop());
        System.out.println("   Remaining: " + undoStack);
        
        // 4. Expression evaluation (postfix)
        System.out.println("\n4. Expression Evaluation:");
        System.out.println("   Postfix: 3 4 + 2 * (evaluates to 14)");
        System.out.println("   Use stack to store operands");
        System.out.println();
    }
    
    // Modern alternatives to Stack
    private static void modernAlternatives() {
        System.out.println("=== Modern Alternatives ===");
        
        // ArrayDeque as Stack (recommended)
        Deque<Integer> arrayDequeStack = new ArrayDeque<>();
        arrayDequeStack.push(1);
        arrayDequeStack.push(2);
        arrayDequeStack.push(3);
        System.out.println("ArrayDeque as Stack: " + arrayDequeStack);
        System.out.println("Pop from ArrayDeque: " + arrayDequeStack.pop());
        
        // LinkedList as Stack
        Deque<Integer> linkedListStack = new LinkedList<>();
        linkedListStack.push(1);
        linkedListStack.push(2);
        linkedListStack.push(3);
        System.out.println("LinkedList as Stack: " + linkedListStack);
        System.out.println("Pop from LinkedList: " + linkedListStack.pop());
        
        System.out.println("\nRecommendations:");
        System.out.println("- Use ArrayDeque for stack operations (fastest)");
        System.out.println("- Use LinkedList if frequent insertions at middle");
        System.out.println("- Avoid Stack class for new code (legacy issues)");
        System.out.println("- ArrayDeque: Not synchronized, better performance");
        System.out.println("- LinkedList: Implements Deque, more flexible");
    }
}

