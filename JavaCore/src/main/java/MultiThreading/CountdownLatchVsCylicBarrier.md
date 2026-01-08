# CountDownLatch vs CyclicBarrier (Java Concurrency)

This document explains the differences between **CountDownLatch** and **CyclicBarrier** in Java with clear explanations, examples, and interview-focused comparisons.

---

## 1. CountDownLatch

### What it is

`CountDownLatch` allows **one or more threads to wait** until a **set of operations completes**.

### Mental Model

> "Wait until these N tasks are completed"

### Key Points

* Initialized with a **count**
* Threads call `countDown()` to reduce the count
* Waiting threads call `await()`
* Once count reaches **0**, latch opens
* **Not reusable**

### Example

```java
CountDownLatch latch = new CountDownLatch(3);

Runnable task = () -> {
    System.out.println(Thread.currentThread().getName() + " finished");
    latch.countDown();
};

new Thread(task).start();
new Thread(task).start();
new Thread(task).start();

latch.await();
System.out.println("All tasks completed");
```

### Use Cases

* Waiting for multiple services to start
* Waiting for multiple files to download
* Integration test setup

---

## 2. CyclicBarrier

### What it is

`CyclicBarrier` allows a **group of threads to wait for each other** at a common point.

### Mental Model

> "Everyone must reach here before anyone can continue"

### Key Points

* Initialized with **number of threads**
* Threads call `await()`
* Once all arrive, barrier opens
* Can execute a **barrier action**
* **Reusable (cyclic)**

### Example

```java
CyclicBarrier barrier = new CyclicBarrier(3, () ->
    System.out.println("All threads reached barrier")
);

Runnable task = () -> {
    System.out.println(Thread.currentThread().getName() + " waiting");
    try {
        barrier.await();
    } catch (Exception e) {
        e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + " proceeding");
};

new Thread(task).start();
new Thread(task).start();
new Thread(task).start();
```

### Use Cases

* Parallel computation in phases
* Multiplayer game rounds
* Matrix or batch processing

---

## 3. Comparison Table

| Feature        | CountDownLatch           | CyclicBarrier            |
| -------------- | ------------------------ | ------------------------ |
| Reusable       | ❌ No                     | ✅ Yes                    |
| Purpose        | Wait for tasks to finish | Wait for threads to meet |
| Direction      | Worker → Waiting thread  | Peer-to-peer             |
| Counter        | Only decrements          | Resets automatically     |
| Barrier Action | ❌ No                     | ✅ Yes                    |

---

## 4. When to Use Which?

### Use CountDownLatch when:

* One or more threads must wait for others
* One-time synchronization is needed
* Tasks are independent

### Use CyclicBarrier when:

* Threads work in **phases**
* Each phase needs all threads to complete
* Synchronization must repeat

---

## 5. Interview One-Liner

> **CountDownLatch** waits for tasks to complete once, while **CyclicBarrier** lets threads wait for each other repeatedly.

---

## 6. Common Interview Mistake

❌ Saying both are the same

✅ Correct answer: They solve **different synchronization problems**

---

## 7. Related Topics to Study

* Semaphore
* Phaser
* ExecutorService
* Thread lifecycle
* Java Memory Model

---

**Author:** Abhijeet Atmapoojya
