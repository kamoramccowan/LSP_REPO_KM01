package org.howard.edu.lspfinal.question2;

/**
 * Represents a task with a name, priority, and status.
 */
public class Task {
    private String name;
    private int priority;
    private String status;

    /**
     * Constructs a new Task.
     * 
     * @param name     the name of the task
     * @param priority the priority (lower = higher priority)
     * @param status   the status ("TODO", "IN_PROGRESS", or "DONE")
     */
    public Task(String name, int priority, String status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    /**
     * Returns the name of the task.
     * 
     * @return task name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the status of the task.
     * 
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Updates the status of the task.
     * 
     * @param status the new status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns a string representation of the task.
     */
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + ", status='" + status + "'}";
    }
}
