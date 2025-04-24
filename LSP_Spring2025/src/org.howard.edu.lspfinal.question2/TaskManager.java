package org.howard.edu.lspfinal.question2;

import java.util.*;

/**
 * Manages a list of tasks, allowing adding, updating, and retrieving.
 */
public class TaskManager {
    private Map<String, Task> taskMap = new HashMap<>();

    /**
     * Adds a new task to the manager.
     * 
     * @param name     the name of the task
     * @param priority the priority (lower number = higher priority)
     * @param status   the initial status ("TODO", "IN_PROGRESS", or "DONE")
     * @throws DuplicateTaskException if a task with the same name already exists
     */
    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (taskMap.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exists.");
        }
        taskMap.put(name, new Task(name, priority, status));
    }

    /**
     * Retrieves a task by name.
     * 
     * @param name the task name
     * @return the Task object
     * @throws TaskNotFoundException if task not found
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        if (!taskMap.containsKey(name)) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        return taskMap.get(name);
    }

    /**
     * Updates the status of an existing task.
     * 
     * @param name   the task name
     * @param status the new status
     * @throws TaskNotFoundException if the task doesn't exist
     */
    public void updateStatus(String name, String status) throws TaskNotFoundException {
        Task task = getTaskByName(name);  // will throw exception if not found
        task.setStatus(status);
    }

    /**
     * Prints all tasks grouped by their current status.
     */
    public void printTasksGroupedByStatus() {
        System.out.println("Tasks grouped by status:");
        List<String> statuses = Arrays.asList("TODO", "IN_PROGRESS", "DONE");

        for (String status : statuses) {
            System.out.println(status + ":");
            for (Task task : taskMap.values()) {
                if (task.getStatus().equals(status)) {
                    System.out.println("  " + task);
                }
            }
        }
    }
}
