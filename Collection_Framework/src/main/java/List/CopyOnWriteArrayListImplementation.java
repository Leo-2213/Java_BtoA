package List;

import java.util.*;
import java.util.concurrent.*;

/*
 * COPYONWRITEARRAYLIST OVERVIEW:
 * - Thread-safe variant of ArrayList for concurrent read-heavy scenarios
 * - Creates a new copy of underlying array on every write operation
 * - Reads are lock-free and don't block writes (and vice versa)
 * - Iterators are snapshot-based and never throw ConcurrentModificationException
 * 
 * COPY-ON-WRITE MECHANISM:
 * - Read operations: Direct access to current array (no synchronization)
 * - Write operations: Create new array copy, modify it, then replace reference
 * - Atomic reference update ensures thread safety
 * 
 * STRUCTURE: 
 * Thread1 (read): [1,2,3] ← reading from snapshot
 * Thread2 (write): [1,2,3] → [1,2,3,4] ← creates new array
 * 
 * PROS:
 * - Excellent for read-heavy workloads (no read locks)
 * - Thread-safe without explicit synchronization
 * - Iterators never fail with ConcurrentModificationException
 * - Snapshot isolation for consistent reads
 * 
 * CONS:
 * - Expensive write operations O(n) - full array copy
 * - High memory usage (multiple array copies)
 * - Eventual consistency (reads may see stale data)
 * - Not suitable for write-heavy scenarios
 * 
 * WHEN TO USE:
 * - Read-heavy concurrent applications (90%+ reads)
 * - Observer/listener patterns
 * - Configuration data that rarely changes
 * - When you need fail-safe iterators
 * 
 * ALTERNATIVES:
 * - Collections.synchronizedList() - synchronized wrapper
 * - Vector - legacy synchronized list
 * - ConcurrentLinkedQueue - for queue operations
 */
public class CopyOnWriteArrayListImplementation {

    public static void main(String[] args) {
        // Basic CopyOnWriteArrayList Operations
        basicOperations();
        
        // Thread safety demonstration
        threadSafetyDemo();
        
        // Iterator behavior
        iteratorBehavior();
        
        // Performance comparison
        performanceComparison();
        
        // Use case examples
        useCaseExamples();
    }
    
    // Basic operations - writes are expensive, reads are fast
    private static void basicOperations() {
        System.out.println("=== Basic Operations ===");
        CopyOnWriteArrayList<Integer> cowList = new CopyOnWriteArrayList<>();
        
        // Write operations - O(n) due to array copying
        cowList.add(1);
        cowList.add(2);
        cowList.add(3);
        cowList.add(4);
        System.out.println("After additions: " + cowList);
        System.out.println("Each add() creates a new internal array copy");
        
        // Read operations - O(1) direct array access, no locks
        System.out.println("Element at index 2: " + cowList.get(2));
        System.out.println("Size: " + cowList.size());
        System.out.println("Contains 3: " + cowList.contains(3));
        
        // Modification operations - expensive due to copying
        cowList.set(1, 10); // O(n) - creates new array
        System.out.println("After set(1, 10): " + cowList);
        
        cowList.remove(Integer.valueOf(3)); // O(n) - creates new array
        System.out.println("After remove(3): " + cowList);
        System.out.println();
    }
    
    // Demonstrating thread safety without explicit synchronization
    private static void threadSafetyDemo() {
        System.out.println("=== Thread Safety Demo ===");
        CopyOnWriteArrayList<String> cowList = new CopyOnWriteArrayList<>();
        cowList.addAll(Arrays.asList("A", "B", "C"));
        
        System.out.println("Initial list: " + cowList);
        System.out.println("Multiple threads can safely read/write simultaneously");
        
        // Simulate concurrent access (simplified example)
        System.out.println("Thread 1 (reader): Gets snapshot of current array");
        System.out.println("Thread 2 (writer): Creates new array with modifications");
        System.out.println("No ConcurrentModificationException thrown");
        
        // Safe concurrent modification during iteration
        System.out.println("\nSafe modification during iteration:");
        for (String item : cowList) {
            System.out.println("Reading: " + item);
            if ("B".equals(item)) {
                cowList.add("D"); // Safe to modify during iteration
                System.out.println("Added 'D' during iteration - no exception");
            }
        }
        System.out.println("Final list: " + cowList);
        System.out.println();
    }
    
    // Iterator behavior - snapshot-based, fail-safe
    private static void iteratorBehavior() {
        System.out.println("=== Iterator Behavior ===");
        CopyOnWriteArrayList<Integer> cowList = new CopyOnWriteArrayList<>();
        cowList.addAll(Arrays.asList(1, 2, 3, 4, 5));
        
        System.out.println("Original list: " + cowList);
        
        // Iterator sees snapshot at creation time
        Iterator<Integer> iterator = cowList.iterator();
        System.out.println("Iterator created (sees current snapshot)");
        
        // Modify list after iterator creation
        cowList.add(6);
        cowList.remove(Integer.valueOf(1));
        System.out.println("List modified after iterator creation: " + cowList);
        
        // Iterator still sees original snapshot
        System.out.print("Iterator sees original snapshot: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        
        // New iterator sees current state
        System.out.print("New iterator sees current state: ");
        for (Integer item : cowList) {
            System.out.print(item + " ");
        }
        System.out.println("\n");
    }
    
    // Performance comparison with ArrayList and Vector
    private static void performanceComparison() {
        System.out.println("=== Performance Comparison ===");
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        Vector<Integer> vector = new Vector<>();
        CopyOnWriteArrayList<Integer> cowList = new CopyOnWriteArrayList<>();
        
        System.out.println("READ PERFORMANCE (concurrent scenarios):");
        System.out.println("CopyOnWriteArrayList: Fastest (no locks, direct access)");
        System.out.println("ArrayList: Fast (but not thread-safe)");
        System.out.println("Vector: Slower (synchronized methods)");
        
        System.out.println("\nWRITE PERFORMANCE:");
        System.out.println("ArrayList: Fastest (O(1) amortized)");
        System.out.println("Vector: Moderate (O(1) amortized + synchronization)");
        System.out.println("CopyOnWriteArrayList: Slowest (O(n) array copying)");
        
        System.out.println("\nMEMORY USAGE:");
        System.out.println("ArrayList/Vector: Efficient (single array)");
        System.out.println("CopyOnWriteArrayList: High (multiple array copies)");
        
        System.out.println("\nCONCURRENCY:");
        System.out.println("ArrayList: Not thread-safe");
        System.out.println("Vector: Thread-safe (synchronized methods)");
        System.out.println("CopyOnWriteArrayList: Thread-safe (copy-on-write)");
        System.out.println();
    }
    
    // Real-world use case examples
    private static void useCaseExamples() {
        System.out.println("=== Use Case Examples ===");
        
        // 1. Observer pattern
        System.out.println("1. Observer Pattern (Event Listeners):");
        CopyOnWriteArrayList<String> listeners = new CopyOnWriteArrayList<>();
        listeners.add("UIListener");
        listeners.add("LoggingListener");
        listeners.add("MetricsListener");
        System.out.println("   Event listeners: " + listeners);
        System.out.println("   Safe to add/remove listeners during event notification");
        
        // 2. Configuration management
        System.out.println("\n2. Configuration Management:");
        CopyOnWriteArrayList<String> configs = new CopyOnWriteArrayList<>();
        configs.addAll(Arrays.asList("config1=value1", "config2=value2"));
        System.out.println("   Configurations: " + configs);
        System.out.println("   Multiple threads read config, occasional updates");
        
        // 3. Cache with occasional updates
        System.out.println("\n3. Read-Heavy Cache:");
        CopyOnWriteArrayList<String> cache = new CopyOnWriteArrayList<>();
        cache.addAll(Arrays.asList("cachedItem1", "cachedItem2", "cachedItem3"));
        System.out.println("   Cache items: " + cache);
        System.out.println("   Frequent reads, infrequent cache refresh");
        
        System.out.println("\nBEST PRACTICES:");
        System.out.println("- Use when reads >> writes (90%+ read operations)");
        System.out.println("- Ideal for observer/listener patterns");
        System.out.println("- Good for configuration data");
        System.out.println("- Avoid for write-heavy scenarios");
        System.out.println("- Consider memory implications of copying");
    }
}

