# 🧵 Java Threading Basics - Complete Guide

> **A comprehensive guide to Java multithreading fundamentals, covering Thread vs Runnable, daemon threads, and best practices.**

---

## 📋 Table of Contents
1. [Creating Threads](#-creating-threads)
2. [Thread vs Runnable](#-thread-vs-runnable)
3. [Essential Thread Methods](#-essential-thread-methods)
4. [Thread States](#-thread-states)
5. [Thread Priorities](#-thread-priorities)
6. [Daemon Threads](#-daemon-threads)
7. [Best Practices](#-best-practices)
8. [Common Patterns](#-common-patterns)
9. [Thread Safety](#-thread-safety)
10. [Modern Alternatives](#-modern-alternatives)

---

## 🚀 Creating Threads

Java provides **two main approaches** to create threads:

### 🔹 Method 1: Extending Thread Class

```java
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running: " + getName());
    }
}

// Usage
MyThread thread = new MyThread();
thread.start(); // ✅ Correct way
```

### 🔹 Method 2: Implementing Runnable Interface

```java
class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Task is running");
    }
}

// Usage
MyTask task = new MyTask();
Thread thread = new Thread(task, "TaskThread");
thread.start(); // ✅ Correct way
```

---

## ⚖️ Thread vs Runnable

### 🟢 **Use Runnable Interface When:**
- ✅ **Better design** - separates task from thread management
- ✅ **Multiple inheritance** - class already extends another class
- ✅ **Reusability** - same task can run on different threads
- ✅ **Thread pools** - ExecutorService works with Runnable
- ✅ **Production code** - more flexible and maintainable

### 🟡 **Use Thread Class When:**
- ⚠️ **Simple scenarios** with basic threading needs
- ⚠️ **Quick prototyping** or learning
- ⚠️ **Direct thread control** is needed

### 📊 **Comparison Table**

| 🔍 **Aspect** | 🧵 **Thread Class** | 🎯 **Runnable Interface** |
|---------------|---------------------|---------------------------|
| **Inheritance** | ❌ Uses single inheritance | ✅ Allows multiple inheritance |
| **Flexibility** | ❌ Less flexible | ✅ More flexible |
| **Reusability** | ❌ Limited | ✅ High |
| **Design** | ❌ Tight coupling | ✅ Loose coupling |
| **Thread Pools** | ❌ Not suitable | ✅ Perfect fit |
| **Best Practice** | ❌ Avoid in production | ✅ Recommended |

> 💡 **Recommendation**: Always prefer `Runnable` interface for production code!

---

## 🛠️ Essential Thread Methods

### 🎮 **Thread Creation and Control**

```java
// 🚀 Creating and starting
Thread thread = new Thread(runnable, "ThreadName");
thread.start();                              // Start thread execution

// ⚙️ Thread properties
thread.setName("NewName");                   // Set thread name
thread.setDaemon(true);                      // Make daemon (before start!)
thread.setPriority(Thread.MAX_PRIORITY);     // Set priority (1-10)

// 📊 Getting thread info
String name = thread.getName();              // Get thread name
int priority = thread.getPriority();         // Get priority
boolean isDaemon = thread.isDaemon();        // Check if daemon
Thread.State state = thread.getState();      // Get current state
```

### 🔄 **Thread Synchronization and Control**

```java
// ⏳ Waiting for thread completion
thread.join();                               // Wait indefinitely
thread.join(5000);                          // Wait max 5 seconds

// ⛔ Thread interruption
thread.interrupt();                          // Interrupt the thread
boolean interrupted = thread.isInterrupted(); // Check if interrupted

// 😴 Sleep and yield
Thread.sleep(1000);                         // Sleep for 1 second
Thread.yield();                             // Hint to scheduler

// 📍 Current thread info
Thread current = Thread.currentThread();    // Get current thread
int activeCount = Thread.activeCount();     // Count active threads
```

---

## 🔄 Thread States

### 📋 **State Descriptions**

| 🏷️ **State** | 📝 **Description** |
|--------------|-------------------|
| 🆕 **NEW** | Thread created but not started |
| 🏃 **RUNNABLE** | Thread executing or ready to execute |
| 🚫 **BLOCKED** | Thread blocked waiting for monitor lock |
| ⏸️ **WAITING** | Thread waiting indefinitely |
| ⏰ **TIMED_WAITING** | Thread waiting for specified time |
| ✅ **TERMINATED** | Thread completed execution |

```java
Thread.State state = thread.getState();
System.out.println("📊 Thread state: " + state);
```

---

## 🎯 Thread Priorities

```java
// 📊 Priority constants
Thread.MIN_PRIORITY   // 1  (Lowest)
Thread.NORM_PRIORITY  // 5  (Default)
Thread.MAX_PRIORITY   // 10 (Highest)

// ⚙️ Setting priority
thread.setPriority(Thread.MAX_PRIORITY);
```

> ⚠️ **Important**: Thread priority is a **hint** to the scheduler, not a guarantee!

---

## 👻 Daemon Threads

### 🤔 **What are Daemon Threads?**

> Daemon threads are **background service threads** that automatically terminate when all user threads finish.

### ✨ **Key Characteristics:**
- 🔄 **Background service** threads
- 🚪 **JVM exits** when only daemon threads remain
- 🔁 **Automatically terminate** when user threads finish
- 🎯 **Low priority** - don't prevent JVM shutdown

### 🌟 **Common Examples:**
- 🗑️ Garbage Collector
- 🧹 Finalizer thread
- 📡 Signal dispatcher
- 📊 Background monitoring tasks

### 💻 **Usage Example:**

```java
Thread daemon = new Thread(() -> {
    while (true) {
        System.out.println("👻 Daemon working...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            break;
        }
    }
}, "DaemonThread");

daemon.setDaemon(true);  // ⚠️ Must be before start()!
daemon.start();
```

> 🚨 **Critical**: `setDaemon(true)` must be called **before** `start()`, otherwise `IllegalThreadStateException` is thrown!

---

## ✅ Best Practices

### 🟢 **DO:**
- ✅ **Use Runnable interface** for better design
- ✅ **Handle InterruptedException** properly
- ✅ **Use meaningful thread names** for debugging
- ✅ **Set daemon appropriately** for background tasks
- ✅ **Use thread pools** for production applications
- ✅ **Always call start()**, never run() directly

### 🔴 **DON'T:**
- ❌ **Call run() directly** - always use start()
- ❌ **Start same thread twice** - throws IllegalThreadStateException
- ❌ **Ignore InterruptedException** - handle or propagate
- ❌ **Use stop(), suspend(), resume()** - deprecated and unsafe
- ❌ **Forget to handle thread interruption**

---

## 🎨 Common Patterns

### 🔥 **Lambda Expression (Java 8+)**

```java
Thread thread = new Thread(() -> {
    System.out.println("🚀 Lambda thread: " + Thread.currentThread().getName());
});
thread.start();
```

### 📦 **Anonymous Class**

```java
Thread thread = new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println("📦 Anonymous thread running");
    }
});
thread.start();
```

### 🛡️ **Thread with Exception Handling**

```java
Thread thread = new Thread(() -> {
    try {
        // 💼 Thread work
        Thread.sleep(1000);
        System.out.println("✅ Work completed");
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt(); // 🔄 Restore interrupt status
        System.out.println("⛔ Thread interrupted");
    }
}, "SafeThread");
thread.start();
```

---

## 🔒 Thread Safety

### ⚠️ **The Problem: Race Conditions**

```java
// ❌ NOT thread-safe
class UnsafeCounter {
    private int count = 0;
    
    public void increment() {
        count++; // 🚨 Race condition!
    }
}
```

### ✅ **The Solution: Synchronization**

```java
// ✅ Thread-safe
class SafeCounter {
    private int count = 0;
    
    public synchronized void increment() {
        count++; // 🔒 Thread-safe
    }
    
    public synchronized int getCount() {
        return count; // 🔒 Thread-safe
    }
}
```

### 🛡️ **Key Points:**
- 🔄 **Synchronization needed** for shared mutable data
- ⚡ **Race conditions** occur without proper synchronization
- 🔒 **Use synchronized methods/blocks** or concurrent collections
- 🎯 **Atomic operations** for simple cases

---

## 🚀 Modern Alternatives

> While Thread and Runnable are fundamental, modern Java offers better alternatives:

### 🎯 **ExecutorService (Recommended for Production)**

```java
ExecutorService executor = Executors.newFixedThreadPool(4);

// Submit tasks
executor.submit(() -> {
    System.out.println("🎯 Task executed by: " + Thread.currentThread().getName());
});

// Proper shutdown
executor.shutdown();
```

### ⚡ **CompletableFuture (Asynchronous Programming)**

```java
CompletableFuture<String> future = CompletableFuture
    .supplyAsync(() -> "Hello")
    .thenApply(s -> s + " World!")
    .thenApply(String::toUpperCase);

System.out.println(future.get()); // "HELLO WORLD!"
```

### 🔧 **Other Modern Tools:**
- 🔢 **AtomicInteger, AtomicReference** - Lock-free programming
- 📚 **ConcurrentHashMap, CopyOnWriteArrayList** - Thread-safe collections
- 🎭 **ForkJoinPool** - Work-stealing thread pool
- 🌊 **Parallel Streams** - Parallel processing

---

## 🎯 Summary

### 🔑 **Key Takeaways:**

1. 🏆 **Prefer Runnable** over Thread class
2. 👻 **Use daemon threads** for background services
3. 🔒 **Synchronize shared resources** to prevent race conditions
4. 🎯 **Use ExecutorService** for production applications
5. 🛡️ **Handle InterruptedException** properly
6. 📝 **Use meaningful thread names** for debugging

### 🚀 **For Production Code, Consider:**
- 🎯 **ExecutorService** for thread management
- ⚡ **CompletableFuture** for asynchronous operations
- 📚 **Concurrent collections** for thread-safe data structures
- 🔢 **Atomic classes** for lock-free programming

> 💡 **Remember**: Understanding Thread and Runnable basics is essential, but leverage higher-level abstractions for robust, maintainable code!

---

*📚 Happy Threading! 🧵*