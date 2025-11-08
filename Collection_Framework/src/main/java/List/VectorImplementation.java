package List;

import java.util.*;

/*
 * VECTOR OVERVIEW:
 * - Legacy synchronized resizable array implementation (since JDK 1.0)
 * - Similar to ArrayList but with synchronized methods
 * - Default initial capacity: 10, doubles when full (vs ArrayList's 50% growth)
 * - Implements List, RandomAccess, Cloneable, Serializable
 * 
 * STRUCTURE: [elem0][elem1][elem2]...[elemN][null][null]... (synchronized access)
 * 
 * PROS:
 * - Thread-safe (all methods synchronized)
 * - Legacy compatibility
 * - Same O(1) random access as ArrayList
 * - Enumeration support (legacy iteration)
 * 
 * CONS:
 * - Performance overhead due to synchronization
 * - Doubles capacity (vs ArrayList's 50% growth) - memory wastage
 * - Legacy design - modern alternatives preferred
 * - Synchronization on individual methods (not atomic operations)
 * 
 * VECTOR vs ARRAYLIST:
 * - Vector: Synchronized, legacy, doubles capacity
 * - ArrayList: Not synchronized, modern, 50% growth
 * 
 * WHEN TO USE:
 * - Legacy code compatibility
 * - Simple thread-safety needs (prefer Collections.synchronizedList() or ConcurrentList)
 * - When you need Enumeration interface
 */
public class VectorImplementation {
    public static void main(String[] args) {
        // Basic Vector Operations
        basicOperations();
        
        // Vector-specific methods
        vectorSpecificMethods();
        
        // Thread safety demonstration
        threadSafetyDemo();
        
        // Vector vs ArrayList comparison
        performanceComparison();
    }
    
    // Basic operations - all synchronized for thread safety
    private static void basicOperations() {
        System.out.println("=== Basic Operations ===");
        Vector<Integer> vector = new Vector<>();
        
        // Adding elements - O(1) amortized, synchronized
        vector.add(1);
        vector.add(2);
        vector.add(4);
        vector.add(3, 3); // Insert at index 3 - O(n) due to shifting
        System.out.println("After additions: " + vector);
        
        // Modifying elements - O(1) synchronized access
        vector.set(2, 5);
        System.out.println("After set(2, 5): " + vector);
        
        // Sorting - O(n log n) with synchronized access
        vector.sort((a, b) -> Integer.compare(b, a)); // Safe comparison
        System.out.println("After descending sort: " + vector);
        
        // Accessing elements - O(1) synchronized
        System.out.println("Element at index 2: " + vector.get(2));
        
        // Removing elements - O(n) due to shifting
        vector.remove(2);
        System.out.println("After remove(2): " + vector);
        
        // Clear all elements - O(1)
        vector.clear();
        System.out.println("After clear: " + vector);
        System.out.println();
    }
    
    // Vector-specific methods and legacy features
    private static void vectorSpecificMethods() {
        System.out.println("=== Vector Specific Methods ===");
        Vector<String> vector = new Vector<>(Arrays.asList("A", "B", "C"));
        System.out.println("Initial vector: " + vector);
        
        // Capacity management - Vector doubles capacity
        System.out.println("Initial capacity: " + vector.capacity());
        vector.ensureCapacity(20);
        System.out.println("After ensureCapacity(20): " + vector.capacity());
        
        // Legacy methods
        vector.addElement("D"); // Legacy add method
        vector.insertElementAt("X", 1); // Legacy insert
        System.out.println("After legacy additions: " + vector);
        
        // Element access
        System.out.println("First element: " + vector.firstElement());
        System.out.println("Last element: " + vector.lastElement());
        
        // Legacy enumeration (older than Iterator)
        System.out.print("Enumeration: ");
        Enumeration<String> enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.print(enumeration.nextElement() + " ");
        }
        System.out.println("\n");
    }
    
    // Demonstrating thread safety (basic example)
    private static void threadSafetyDemo() {
        System.out.println("=== Thread Safety Demo ===");
        Vector<Integer> vector = new Vector<>();
        
        // Vector methods are synchronized - thread-safe for individual operations
        System.out.println("Vector is thread-safe for individual operations");
        System.out.println("All methods are synchronized");
        
        // Note: For compound operations, external synchronization still needed
        System.out.println("For compound operations, use synchronized blocks");
        
        // Example of safe single operations
        vector.add(1);
        vector.add(2);
        vector.add(3);
        System.out.println("Thread-safe additions: " + vector);
        System.out.println();
    }
    
    // Performance comparison with ArrayList
    private static void performanceComparison() {
        System.out.println("=== Performance Comparison ===");
        
        // Vector creation
        Vector<Integer> vector = new Vector<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        
        System.out.println("Vector: Synchronized, thread-safe, slower");
        System.out.println("ArrayList: Not synchronized, faster, not thread-safe");
        
        // Capacity growth comparison
        System.out.println("\nCapacity Growth:");
        System.out.println("Vector: Doubles (10 -> 20 -> 40)");
        System.out.println("ArrayList: 50% increase (10 -> 15 -> 22)");
        
        // Modern alternatives
        System.out.println("\nModern Alternatives:");
        System.out.println("- Collections.synchronizedList(new ArrayList<>())");
        System.out.println("- CopyOnWriteArrayList (for read-heavy scenarios)");
        System.out.println("- ConcurrentLinkedQueue (for concurrent access)");
    }
}
