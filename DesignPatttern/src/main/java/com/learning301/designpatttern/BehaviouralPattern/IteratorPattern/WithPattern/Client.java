package com.learning301.designpatttern.BehaviouralPattern.IteratorPattern.WithPattern;

/**
 * Client - WITH Iterator Pattern
 * 
 * Benefits demonstrated:
 * 1. ENCAPSULATION - No direct access to internal collection
 * 2. ABSTRACTION - Uses Iterator interface, not specific collection type
 * 3. SECURITY - Cannot accidentally modify collection during iteration
 * 4. FLEXIBILITY - Collection can change internal storage without breaking client
 * 5. UNIFORM INTERFACE - Same iteration pattern for any collection type
 * 6. MULTIPLE ITERATIONS - Can create multiple iterators simultaneously
 */
public class Client {
    public static void main(String[] args) {
        // Create collection
        BookCollection bookCollection = new BookCollection();
        
        // Add books to collection
        bookCollection.addBook(new Book("Design Patterns"));
        bookCollection.addBook(new Book("Clean Code"));
        bookCollection.addBook(new Book("Effective Java"));
        bookCollection.addBook(new Book("Spring in Action"));
        bookCollection.addBook(new Book("Java Concurrency"));

        // ITERATOR PATTERN BENEFITS:
        
        // 1. SAFE ITERATION - No direct collection access
        Iterator<Book> iterator = bookCollection.createIterator();
        
        System.out.println("=== Iterating through books ===");
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println("Book: " + book);
        }
        
        // 2. MULTIPLE SIMULTANEOUS ITERATIONS
        System.out.println("\n=== Demonstrating multiple iterators ===");
        Iterator<Book> iterator1 = bookCollection.createIterator();
        Iterator<Book> iterator2 = bookCollection.createIterator();
        
        // Both iterators work independently
        System.out.println("Iterator 1 - First book: " + iterator1.next());
        System.out.println("Iterator 2 - First book: " + iterator2.next());
        System.out.println("Iterator 1 - Second book: " + iterator1.next());
        
        // 3. NO SECURITY RISKS
        // Cannot do: bookCollection.getBooks().clear() - method doesn't exist!
        // Cannot accidentally modify collection during iteration
        
        // 4. ABSTRACTION
        // Client doesn't know if collection uses ArrayList, LinkedList, Array, etc.
        // Collection can change internal implementation without breaking client code
        
        System.out.println("\n=== Iterator Pattern Benefits Demonstrated ===");
        System.out.println("✓ Encapsulation maintained");
        System.out.println("✓ No direct collection access");
        System.out.println("✓ Multiple iterators supported");
        System.out.println("✓ Uniform iteration interface");
        System.out.println("✓ Collection implementation hidden");
    }
}
