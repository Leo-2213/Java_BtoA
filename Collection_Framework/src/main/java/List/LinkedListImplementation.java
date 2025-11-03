package List;

import java.util.*;

/*
 * LINKEDLIST OVERVIEW:
 * - Doubly-linked list implementation of List and Deque interfaces
 * - Each element (node) contains data + references to next and previous nodes
 * - Dynamic size, elements stored in non-contiguous memory locations
 * 
 * STRUCTURE: [prev|data|next] <-> [prev|data|next] <-> [prev|data|next]
 * 
 * PROS:
 * - O(1) insertion/deletion at beginning/end
 * - Dynamic size (no fixed capacity)
 * - Implements List, Queue, Deque, Stack interfaces
 * - Memory efficient for frequent insertions/deletions
 * 
 * CONS:
 * - O(n) random access (must traverse from head/tail)
 * - Higher memory overhead (extra pointers per node)
 * - Poor cache locality (nodes scattered in memory)
 * - No indexed access optimization
 * 
 * WHEN TO USE:
 * - Frequent insertions/deletions at beginning/end
 * - Queue/Stack operations
 * - Unknown or highly variable size
 * - When you don't need random access by index
 */
public class LinkedListImplementation {
    public static void main(String[] args) {
        // Basic LinkedList Operations
        basicOperations();

        // LinkedList-specific methods
        linkedListSpecificMethods();
    }

    // Basic List operations - O(n) for middle operations, O(1) for ends
    private static void basicOperations() {
        System.out.println("=== Basic Operations ===");
        LinkedList<Integer> list = new LinkedList<>();

        // Adding elements - O(1) at end
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println("Initial list: " + list);

        // Insert at specific position - O(n) traversal to index
        list.add(2, 5);
        System.out.println("After insert at index 2: " + list);

        // Remove by index - O(n) traversal to index
        list.remove(2);
        System.out.println("After remove index 2: " + list);

        // Update element - O(n) traversal to index
        list.set(2, 6);
        System.out.println("After set index 2 to 6: " + list);

        // Access elements - O(n) for random access
        System.out.println("First element: " + list.get(0));
        System.out.println("Size: " + list.size());
        System.out.println();
    }

    // LinkedList-specific methods - O(1) operations at both ends
    private static void linkedListSpecificMethods() {
        System.out.println("=== LinkedList Specific Methods ===");
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(2, 4, 6, 8));
        System.out.println("Initial: " + list);

        // Add at beginning and end - O(1) operations
        list.addFirst(0);  // Direct head manipulation
        list.addLast(10);  // Direct tail manipulation
        System.out.println("After addFirst(0) and addLast(10): " + list);

        // Get first and last - O(1) access to head/tail
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());

        // Remove first and last - O(1) operations
        list.removeFirst();  // Update head pointer
        list.removeLast();   // Update tail pointer
        System.out.println("After removeFirst() and removeLast(): " + list);
        System.out.println();
    }
}