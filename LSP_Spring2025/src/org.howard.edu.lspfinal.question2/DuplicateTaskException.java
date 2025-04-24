package org.howard.edu.lspfinal.question2;

/**
 * Exception thrown when a duplicate task is added to the TaskManager.
 */
public class DuplicateTaskException extends Exception {
    public DuplicateTaskException(String message) {
        super(message);
    }
}
