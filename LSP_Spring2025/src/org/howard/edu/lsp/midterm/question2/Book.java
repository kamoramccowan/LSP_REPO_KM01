package org.howard.edu.lsp.midterm.question2;

import java.util.Objects;

/**
 * Represents a book in a library system.
 * Encapsulates book details such as title, author, ISBN, and year published.
 *  
 * Kamora Mccowan 
 * Large Scale Programming Midterm - March 20, 2025
 */
public class Book {
    // Private attributes to enforce encapsulation
    private String title;
    private String author;
    private String ISBN;
    private int yearPublished;

    /** 
     * Constructor to initialize book details.
     * 
     * @param title          Title of the book
     * @param author         Author of the book
     * @param ISBN           ISBN number of the book
     * @param yearPublished  Year the book was published
     */
    public Book(String title, String author, String ISBN, int yearPublished) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
    }

    // Getters and Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    /**
     * Overrides equals method to compare Book objects.
     * Two books are considered equal if they have the same ISBN and author.
     * 
     * @param obj The object to compare with
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Same reference
        }
        if (obj == null || getClass() != obj.getClass()) {
            return f
