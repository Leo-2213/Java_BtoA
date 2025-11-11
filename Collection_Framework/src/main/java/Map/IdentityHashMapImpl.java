package Map;

import java.util.*;

/*
 * IDENTITYHASHMAP OVERVIEW:
 * - Uses reference equality (==) instead of object equality (equals())
 * - Uses System.identityHashCode() instead of hashCode()
 * - Violates Map's general contract but useful for specific scenarios
 * - Linear probing hash table implementation (not chaining)
 * 
 * KEY DIFFERENCES FROM HASHMAP:
 * HashMap: Uses equals() and hashCode() for key comparison
 * IdentityHashMap: Uses == and System.identityHashCode() for key comparison
 * 
 * INTERNAL STRUCTURE:
 * - Linear probing array: [key1, value1, key2, value2, ...]
 * - Default capacity: 32 (must be power of 2)
 * - Load factor: 2/3 (different from HashMap's 0.75)
 * 
 * PROS:
 * - Faster than HashMap (no equals()/hashCode() calls)
 * - Useful for object tracking and serialization
 * - Prevents issues with mutable keys
 * - Good for topology-preserving transformations
 * 
 * CONS:
 * - Violates Map contract (surprising behavior)
 * - Reference-based equality can be confusing
 * - Limited use cases
 * - Not suitable for general-purpose mapping
 * 
 * WHEN TO USE:
 * - Object serialization/deserialization
 * - Proxy objects and object tracking
 * - Topology-preserving object transformations
 * - When you need reference equality specifically
 */

public class IdentityHashMapImpl {
    public static void main(String[] args) {
        System.out.println("=== IdentityHashMap vs HashMap Comparison ===");
        
        // Basic comparison
        basicComparison();
        
        // String literal vs new String
        stringLiteralDemo();
        
        // Mutable key safety
        mutableKeyDemo();
        
        // Object tracking example
        objectTrackingDemo();
        
        // Serialization scenario
        serializationScenario();
        
        // Performance comparison
        performanceDemo();
    }
    
    // Basic comparison between HashMap and IdentityHashMap
    private static void basicComparison() {
        System.out.println("\n=== Basic Comparison ===");
        
        // Create two identical strings
        String key1 = new String("hello");
        String key2 = new String("hello");
        
        System.out.println("key1.equals(key2): " + key1.equals(key2));           // true
        System.out.println("key1 == key2: " + (key1 == key2));                   // false
        System.out.println("key1.hashCode(): " + key1.hashCode());
        System.out.println("key2.hashCode(): " + key2.hashCode());
        System.out.println("System.identityHashCode(key1): " + System.identityHashCode(key1));
        System.out.println("System.identityHashCode(key2): " + System.identityHashCode(key2));
        
        // HashMap - uses equals() and hashCode()
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(key1, "value1");
        hashMap.put(key2, "value2");  // Overwrites key1's value
        
        System.out.println("\nHashMap behavior (uses equals()):");
        System.out.println("HashMap size: " + hashMap.size());                    // 1
        System.out.println("HashMap.get(key1): " + hashMap.get(key1));           // value2
        System.out.println("HashMap.get(key2): " + hashMap.get(key2));           // value2
        
        // IdentityHashMap - uses == and System.identityHashCode()
        IdentityHashMap<String, String> identityMap = new IdentityHashMap<>();
        identityMap.put(key1, "value1");
        identityMap.put(key2, "value2");  // Creates separate entry
        
        System.out.println("\nIdentityHashMap behavior (uses ==):");
        System.out.println("IdentityHashMap size: " + identityMap.size());       // 2
        System.out.println("IdentityHashMap.get(key1): " + identityMap.get(key1)); // value1
        System.out.println("IdentityHashMap.get(key2): " + identityMap.get(key2)); // value2
    }
    
    // String literal vs new String demonstration
    private static void stringLiteralDemo() {
        System.out.println("\n=== String Literal vs New String ===");
        
        String literal1 = "java";
        String literal2 = "java";        // Same reference (string pool)
        String newStr1 = new String("java");
        String newStr2 = new String("java");
        
        System.out.println("literal1 == literal2: " + (literal1 == literal2));   // true
        System.out.println("newStr1 == newStr2: " + (newStr1 == newStr2));       // false
        System.out.println("literal1 == newStr1: " + (literal1 == newStr1));     // false
        
        IdentityHashMap<String, Integer> identityMap = new IdentityHashMap<>();
        identityMap.put(literal1, 1);
        identityMap.put(literal2, 2);    // Overwrites literal1 (same reference)
        identityMap.put(newStr1, 3);
        identityMap.put(newStr2, 4);
        
        System.out.println("\nIdentityHashMap entries:");
        System.out.println("Size: " + identityMap.size());                       // 3
        System.out.println("literal1 value: " + identityMap.get(literal1));      // 2
        System.out.println("literal2 value: " + identityMap.get(literal2));      // 2
        System.out.println("newStr1 value: " + identityMap.get(newStr1));        // 3
        System.out.println("newStr2 value: " + identityMap.get(newStr2));        // 4
    }
    
    // Mutable key safety demonstration
    private static void mutableKeyDemo() {
        System.out.println("\n=== Mutable Key Safety ===");
        
        // Create mutable objects
        MutableKey key1 = new MutableKey("initial");
        MutableKey key2 = new MutableKey("initial");
        
        HashMap<MutableKey, String> hashMap = new HashMap<>();
        IdentityHashMap<MutableKey, String> identityMap = new IdentityHashMap<>();
        
        // Add to both maps
        hashMap.put(key1, "hashMap-value1");
        hashMap.put(key2, "hashMap-value2");  // Overwrites key1 (equals() returns true)
        
        identityMap.put(key1, "identityMap-value1");
        identityMap.put(key2, "identityMap-value2");  // Separate entries (different objects)
        
        System.out.println("Before mutation:");
        System.out.println("HashMap size: " + hashMap.size());                   // 1
        System.out.println("IdentityHashMap size: " + identityMap.size());       // 2
        
        // Mutate key1
        key1.setValue("modified");
        
        System.out.println("\nAfter mutating key1:");
        System.out.println("HashMap.get(key1): " + hashMap.get(key1));           // null (lost!)
        System.out.println("IdentityHashMap.get(key1): " + identityMap.get(key1)); // identityMap-value1
        
        System.out.println("\nIdentityHashMap is safer with mutable keys!");
    }
    
    // Object tracking example
    private static void objectTrackingDemo() {
        System.out.println("\n=== Object Tracking Example ===");
        
        // Simulate object processing tracking
        IdentityHashMap<Object, ProcessingStatus> processingTracker = new IdentityHashMap<>();
        
        // Create objects to track
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();
        
        // Track processing status
        processingTracker.put(obj1, ProcessingStatus.PENDING);
        processingTracker.put(obj2, ProcessingStatus.IN_PROGRESS);
        processingTracker.put(obj3, ProcessingStatus.COMPLETED);
        
        System.out.println("Object tracking:");
        System.out.println("obj1 status: " + processingTracker.get(obj1));
        System.out.println("obj2 status: " + processingTracker.get(obj2));
        System.out.println("obj3 status: " + processingTracker.get(obj3));
        
        // Update status
        processingTracker.put(obj1, ProcessingStatus.COMPLETED);
        System.out.println("\nAfter updating obj1:");
        System.out.println("obj1 status: " + processingTracker.get(obj1));
        
        // Count by status
        Map<ProcessingStatus, Integer> statusCount = new HashMap<>();
        for (ProcessingStatus status : processingTracker.values()) {
            statusCount.put(status, statusCount.getOrDefault(status, 0) + 1);
        }
        
        System.out.println("\nStatus summary:");
        statusCount.forEach((status, count) -> 
            System.out.println(status + ": " + count + " objects"));
    }
    
    // Serialization scenario
    private static void serializationScenario() {
        System.out.println("\n=== Serialization Scenario ===");
        
        // Simulate object serialization with circular references
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        
        // Create circular references
        nodeA.addChild(nodeB);
        nodeB.addChild(nodeC);
        nodeC.addChild(nodeA);  // Circular reference
        
        // Track serialized objects to avoid infinite loops
        IdentityHashMap<Node, Integer> serializedObjects = new IdentityHashMap<>();
        
        System.out.println("Serializing object graph with circular references:");
        serializeNode(nodeA, serializedObjects, 1);
        
        System.out.println("\nSerialized objects:");
        serializedObjects.forEach((node, id) -> 
            System.out.println("Node " + node.getName() + " -> ID: " + id));
    }
    
    // Helper method for serialization
    private static int serializeNode(Node node, IdentityHashMap<Node, Integer> serialized, int nextId) {
        if (serialized.containsKey(node)) {
            System.out.println("  Found circular reference to Node " + node.getName() + 
                " (ID: " + serialized.get(node) + ")");
            return nextId;
        }
        
        serialized.put(node, nextId);
        System.out.println("  Serializing Node " + node.getName() + " (ID: " + nextId + ")");
        
        int currentId = nextId + 1;
        for (Node child : node.getChildren()) {
            currentId = serializeNode(child, serialized, currentId);
        }
        
        return currentId;
    }
    
    // Performance comparison
    private static void performanceDemo() {
        System.out.println("\n=== Performance Comparison ===");
        
        int iterations = 100000;
        
        // Create test objects
        List<String> keys = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            keys.add(new String("key" + i));
        }
        
        // HashMap performance
        HashMap<String, Integer> hashMap = new HashMap<>();
        long startTime = System.nanoTime();
        
        for (int i = 0; i < iterations; i++) {
            String key = keys.get(i % keys.size());
            hashMap.put(key, i);
            hashMap.get(key);
        }
        
        long hashMapTime = System.nanoTime() - startTime;
        
        // IdentityHashMap performance
        IdentityHashMap<String, Integer> identityMap = new IdentityHashMap<>();
        startTime = System.nanoTime();
        
        for (int i = 0; i < iterations; i++) {
            String key = keys.get(i % keys.size());
            identityMap.put(key, i);
            identityMap.get(key);
        }
        
        long identityMapTime = System.nanoTime() - startTime;
        
        System.out.println("Performance results (" + iterations + " operations):");
        System.out.println("HashMap time: " + (hashMapTime / 1_000_000) + " ms");
        System.out.println("IdentityHashMap time: " + (identityMapTime / 1_000_000) + " ms");
        System.out.println("IdentityHashMap is " + 
            String.format("%.2f", (double) hashMapTime / identityMapTime) + "x faster");
        
        System.out.println("\nNote: IdentityHashMap is faster because it doesn't call equals()/hashCode()");
    }
}

// Helper class for mutable key demonstration
class MutableKey {
    private String value;
    
    public MutableKey(String value) {
        this.value = value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MutableKey that = (MutableKey) obj;
        return Objects.equals(value, that.value);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
    
    @Override
    public String toString() {
        return "MutableKey{value='" + value + "'}";
    }
}

// Processing status enum
enum ProcessingStatus {
    PENDING, IN_PROGRESS, COMPLETED, FAILED
}

// Node class for serialization example
class Node {
    private final String name;
    private final List<Node> children = new ArrayList<>();
    
    public Node(String name) {
        this.name = name;
    }
    
    public void addChild(Node child) {
        children.add(child);
    }
    
    public String getName() {
        return name;
    }
    
    public List<Node> getChildren() {
        return children;
    }
    
    @Override
    public String toString() {
        return "Node{name='" + name + "'}";
    }
}
