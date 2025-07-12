package com.learning301.designpatttern.BehaviouralPattern.IteratorPattern.WithoutPattern;

/**
 * Book - Data class (same in both approaches)
 * 
 * This class represents the elements stored in the collection
 * It remains unchanged whether using Iterator Pattern or not
 * The pattern affects how we traverse collections of these objects
 */
public class Book {
    private String title;

    /**
     * Constructor to create a book with given title
     * @param title the title of the book
     */
    public Book(String  title) {
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
        return "book : " + this.title;
    }
}
