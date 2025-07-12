package com.learning301.designpatttern.BehaviouralPattern.IteratorPattern.WithPattern;

/**
 * Book - Element class (same in both approaches)
 * 
 * Represents the objects stored in the collection
 * The Iterator Pattern doesn't change this class
 * It focuses on how we traverse collections of these objects
 */
public class Book {
    private String title;

    /**
     * Constructor to create a book with given title
     * @param title the title of the book
     */
    public Book(String title){
        this.title = title;
    }

    /**
     * Getter for book title
     * @return the title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * String representation of the book
     * Used when printing book details
     */
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }
}
