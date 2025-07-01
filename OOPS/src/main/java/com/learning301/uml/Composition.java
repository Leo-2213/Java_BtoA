package com.learning301.uml;

import java.util.ArrayList;
import java.util.List;

public class Composition {
        public static void main(String[] args) {
            // Create a book and add pages
            Book book = new Book("The Java Handbook");

            book.addPage("Introduction to Java");
            book.addPage("OOP Concepts");
            book.addPage("Design Patterns");

            // Print book details
            System.out.println(book);
        }
    public static class Book {
        private String title;
        private List<Page> pages;

        Book(String title) {
            this.title = title;
            this.pages = new ArrayList<>();
        }

        // Book creates and owns Pages — strong ownership
        public void addPage(String content) {
            Page page = new Page(content);
            pages.add(page);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("📘 Book: " + title + "\n");
            for (int i = 0; i < pages.size(); i++) {
                sb.append("  Page ").append(i + 1).append(": ").append(pages.get(i)).append("\n");
            }
            return sb.toString();
        }

        // Part class (Page) - no public constructor, only created by Book
        private class Page {
            private String content;

            Page(String content) {
                this.content = content;
            }

            @Override
            public String toString() {
                return content;
            }
        }
    }

}



