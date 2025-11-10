# HashMap - Complete Interview Guide

## 📋 Table of Contents
1. [Overview & Architecture](#overview--architecture)
2. [Internal Working](#internal-working)
3. [Time Complexity Analysis](#time-complexity-analysis)
4. [Key Components](#key-components)
5. [Collision Handling](#collision-handling)
6. [Important Interview Questions](#important-interview-questions)
7. [Code Examples](#code-examples)
8. [Best Practices](#best-practices)

---

## 🏗️ Overview & Architecture

### What is HashMap?
- **Hash table implementation** of Map interface
- Stores **key-value pairs** using hashing mechanism
- **Not synchronized** (not thread-safe)
- Allows **one null key** and **multiple null values**
- **No ordering** guaranteed

### Key Characteristics
```
Default Initial Capacity: 16
Default Load Factor: 0.75
Maximum Capacity: 2^30
Tree Threshold: 8 (LinkedList → Red-Black Tree)
Untree Threshold: 6 (Red-Black Tree → LinkedList)
```

---

## ⚙️ Internal Working

### 1. Internal Structure
```
HashMap Structure:
┌─────────────────────────────────────┐
│     Node<K,V>[] table (buckets)    │
├─────┬─────┬─────┬─────┬─────┬─────┤
│  0  │  1  │  2  │  3  │ ... │ 15  │
└─────┴─────┴─────┴─────┴─────┴─────┘
   │     │     │     │           │
   ▼     ▼     ▼     ▼           ▼
 Node   Node  Tree  null       Node
   │     │     │                 │
   ▼     ▼     ▼                 ▼
 Node   null  Node              null
```

### 2. Node Structure
```java
static class Node<K,V> implements Map.Entry<K,V> {
    final int hash;    // Cached hash value
    final K key;       // Key (immutable)
    V value;           // Value (mutable)
    Node<K,V> next;    // Next node in chain
}
```

### 3. Hashing Process
```java
// Step 1: Calculate hash
int hash = key.hashCode();

// Step 2: Apply hash function (reduce collisions)
hash = hash ^ (hash >>> 16);

// Step 3: Find bucket index
int index = (n - 1) & hash;  // n = table.length
```

### 4. Put Operation Flow
```
1. Calculate hash of key
2. Find bucket index: (n-1) & hash
3. If bucket is empty:
   → Create new node
4. If bucket has nodes:
   → Check if key exists (update value)
   → If not, add to chain/tree
5. If size > threshold:
   → Resize table (double capacity)
```

### 5. Get Operation Flow
```
1. Calculate hash of key
2. Find bucket index: (n-1) & hash
3. If bucket is empty:
   → Return null
4. If bucket has nodes:
   → Traverse chain/tree to find key
   → Return value if found, null otherwise
```

---

## ⏱️ Time Complexity Analysis

### Average Case (Good Hash Distribution)
| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| `put()`   | **O(1)**       | O(1)            |
| `get()`   | **O(1)**       | O(1)            |
| `remove()`| **O(1)**       | O(1)            |
| `containsKey()` | **O(1)** | O(1)            |
| `containsValue()` | **O(n)** | O(1)           |

### Worst Case (All Keys Hash to Same Bucket)
| Operation | Before Java 8 | After Java 8 |
|-----------|----------------|---------------|
| `put()`   | **O(n)**       | **O(log n)**  |
| `get()`   | **O(n)**       | **O(log n)**  |
| `remove()`| **O(n)**       | **O(log n)**  |

### Space Complexity
- **Overall**: O(n) where n = number of key-value pairs
- **Load Factor Impact**: Higher load factor = more collisions, less memory

---

## 🔧 Key Components

### 1. Hash Function
```java
static final int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}
```
**Purpose**: Reduce hash collisions by mixing high and low bits

### 2. Load Factor (0.75)
```java
threshold = capacity * loadFactor
// When size > threshold → resize
```
**Trade-off**:
- Lower (0.5): Less collisions, more memory
- Higher (0.9): More collisions, less memory

### 3. Resize Operation
```java
// Triggered when: size > threshold
newCapacity = oldCapacity * 2
// Rehash all existing entries
```

### 4. Tree-ification (Java 8+)
```java
// Convert LinkedList → Red-Black Tree when bucket size > 8
// Convert Red-Black Tree → LinkedList when bucket size < 6
```

---

## 💥 Collision Handling

### 1. Separate Chaining
```
Bucket 3: Node1 → Node2 → Node3 → null
```

### 2. Tree-ification Process
```
LinkedList (≤8 nodes):  A → B → C → D → E → F → G → H
                        ↓ (when 9th node added)
Red-Black Tree:           D
                                   / \
                                  B   F
                                 / \ / \
                                A  C E  G
                                              \
                                               H
```

### 3. Why Red-Black Tree?
- **Balanced**: Guarantees O(log n) operations
- **Self-balancing**: Maintains balance during insertions/deletions
- **Better than AVL**: Less rotations needed

---

## 🎯 Important Interview Questions

### Q1: Why is HashMap not thread-safe?
**Answer**: Multiple threads can simultaneously modify the internal structure, leading to:
- **Data corruption** during resize operations
- **Infinite loops** in linked lists
- **Lost updates** when multiple threads modify same bucket

**Solution**: Use `ConcurrentHashMap` or `Collections.synchronizedMap()`

### Q2: What happens when two keys have the same hashCode?
**Answer**: 
1. Both keys go to the same bucket
2. HashMap uses `equals()` method to distinguish between keys
3. If `equals()` returns false, both entries coexist in the same bucket (collision)

### Q3: Why override both hashCode() and equals()?
**Answer**:
```java
// Contract: If obj1.equals(obj2) == true, then obj1.hashCode() == obj2.hashCode()
class Person {
    String name;
    int age;
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
```

### Q4: What is the significance of initial capacity being a power of 2?
**Answer**:
- Enables fast modulo operation: `hash % capacity` becomes `hash & (capacity-1)`
- Ensures uniform distribution of hash values
- Optimizes performance of bitwise operations

### Q5: How does HashMap handle null keys?
**Answer**:
- Null key always goes to **bucket 0**
- Only **one null key** allowed (subsequent puts overwrite)
- Hash of null key is always **0**

---

## 💻 Code Examples

### 1. Basic Operations
```java
HashMap<String, Integer> map = new HashMap<>();

// Put - O(1) average
map.put("apple", 10);
map.put("banana", 20);
map.put(null, 30);  // Null key allowed

// Get - O(1) average
Integer value = map.get("apple");  // Returns 10
Integer nullValue = map.get("grape");  // Returns null

// Update
map.put("apple", 15);  // Updates existing key

// Remove - O(1) average
Integer removed = map.remove("banana");  // Returns 20
```

### 2. Collision Example
```java
// These strings have same hashCode!
String str1 = "Aa";
String str2 = "BB";
System.out.println(str1.hashCode());  // 2112
System.out.println(str2.hashCode());  // 2112

HashMap<String, String> map = new HashMap<>();
map.put(str1, "Value1");
map.put(str2, "Value2");  // Goes to same bucket, different nodes
```

### 3. Custom Key Class
```java
class Employee {
    private int id;
    private String name;
    
    // Constructor, getters, setters...
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return id == employee.id && Objects.equals(name, employee.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

// Usage
HashMap<Employee, String> empMap = new HashMap<>();
Employee emp1 = new Employee(1, "John");
empMap.put(emp1, "Developer");
```

### 4. Common Use Cases

#### Frequency Counter
```java
public Map<Character, Integer> countCharacters(String str) {
    Map<Character, Integer> charCount = new HashMap<>();
    for (char c : str.toCharArray()) {
        charCount.put(c, charCount.getOrDefault(c, 0) + 1);
    }
    return charCount;
}
```

#### Two Sum Problem
```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[]{map.get(complement), i};
        }
        map.put(nums[i], i);
    }
    return new int[]{};
}
```

#### Caching/Memoization
```java
private Map<Integer, Integer> fibCache = new HashMap<>();

public int fibonacci(int n) {
    if (n <= 1) return n;
    if (fibCache.containsKey(n)) {
        return fibCache.get(n);  // O(1) lookup
    }
    int result = fibonacci(n-1) + fibonacci(n-2);
    fibCache.put(n, result);
    return result;
}
```

---

## 🎯 Best Practices

### 1. Capacity Planning
```java
// If you know the size, set initial capacity
int expectedSize = 1000;
int initialCapacity = (int) (expectedSize / 0.75) + 1;
HashMap<String, String> map = new HashMap<>(initialCapacity);
```

### 2. Iteration Best Practices
```java
// ✅ Efficient - Single pass through entries
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    String key = entry.getKey();
    Integer value = entry.getValue();
}

// ❌ Inefficient - Double lookup for each key
for (String key : map.keySet()) {
    Integer value = map.get(key);  // Extra O(1) operation
}
```

### 3. Thread Safety
```java
// Option 1: ConcurrentHashMap
Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();

// Option 2: Synchronized wrapper
Map<String, Integer> syncMap = Collections.synchronizedMap(new HashMap<>());

// Option 3: External synchronization
synchronized(map) {
    map.put("key", "value");
}
```

### 4. Null Handling
```java
// Safe null handling
String value = map.get(key);
if (value != null) {
    // Process value
}

// Or use getOrDefault
String value = map.getOrDefault(key, "defaultValue");
```

---

## 🚀 Performance Tips

### 1. Choose Right Initial Capacity
```java
// Good: Prevents multiple resizes
Map<String, String> map = new HashMap<>(1000);

// Bad: Multiple resizes as map grows
Map<String, String> map = new HashMap<>();  // Default: 16
```

### 2. Implement Good hashCode()
```java
// Good: Distributes objects evenly
@Override
public int hashCode() {
    return Objects.hash(field1, field2, field3);
}

// Bad: All objects go to same bucket
@Override
public int hashCode() {
    return 1;  // Terrible hash function!
}
```

### 3. Use Immutable Keys
```java
// Good: String is immutable
Map<String, String> map = new HashMap<>();

// Risky: Mutable key can change hash
Map<List<String>, String> map = new HashMap<>();
List<String> key = new ArrayList<>();
map.put(key, "value");
key.add("newElement");  // Hash changed! Key might be lost
```

---

## 🎪 Interview Scenarios

### Scenario 1: Design a Cache
```java
class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, Node<K, V>> map;
    private final Node<K, V> head, tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node<>(null, null);
        this.tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }
    
    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) return null;
        
        moveToHead(node);
        return node.value;
    }
    
    public void put(K key, V value) {
        Node<K, V> node = map.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            Node<K, V> newNode = new Node<>(key, value);
            if (map.size() >= capacity) {
                Node<K, V> tail = removeTail();
                map.remove(tail.key);
            }
            addToHead(newNode);
            map.put(key, newNode);
        }
    }
    
    // Helper methods for doubly linked list operations...
}
```

### Scenario 2: Group Anagrams
```java
public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    
    for (String str : strs) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String key = String.valueOf(chars);
        
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
    }
    
    return new ArrayList<>(map.values());
}
```

---

## 🎯 Key Takeaways for Interviews

1. **HashMap uses array + linked list/tree** for storage
2. **Average O(1)** for basic operations, **O(log n) worst case** after Java 8
3. **Load factor 0.75** balances time vs space
4. **Tree-ification at 8 nodes** improves worst-case performance
5. **Not thread-safe** - use ConcurrentHashMap for concurrency
6. **Override both hashCode() and equals()** for custom keys
7. **Initial capacity planning** prevents expensive resizes
8. **EntrySet iteration** is more efficient than KeySet

Remember: **Understanding the internal working and being able to explain trade-offs is crucial for senior-level interviews!**