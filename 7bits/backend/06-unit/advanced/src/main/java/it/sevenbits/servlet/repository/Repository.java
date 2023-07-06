package it.sevenbits.servlet.repository;

import it.sevenbits.servlet.model.Task;
import java.util.Collection;

/**
 * The interface Repository.
 */
public interface Repository {
    /**
     * Add task string.
     *
     * @param task the task
     * @return the string
     */
    String addTask(Task task);

    /**
     * Delete task boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean deleteTask(String id);

    /**
     * Gets all tasks.
     *
     * @return the all tasks
     */
    Collection<Task> getAllTasks();

    /**
     * Gets task by id.
     *
     * @param id the id
     * @return the task by id
     */
    Task getTaskById(String id);
}
