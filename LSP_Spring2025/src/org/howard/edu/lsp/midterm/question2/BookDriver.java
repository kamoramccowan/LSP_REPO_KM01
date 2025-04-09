package org.howard.edu.lsp.midterm.question2;

public class BookDriver {
    public static void main(String[] args) {
        // Create the book instances
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book3 = new Book("A Promised Land", "Barack Obama", "9780593239681", 2020);

        // Test equals method
        System.out.println("book1 equals book2: " + book1.equals(book2)); // true
        System.out.println("book1 equals book3: " + book1.equals(book3)); // false
        
        // Print book details
        System.out.println("\nBook Details:\n" + book1);
    }
}
