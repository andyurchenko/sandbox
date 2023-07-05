package it.sevenbits.servlet.repository;

import it.sevenbits.servlet.model.Task;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * The type Repository.
 */
public class RepositoryImpl implements Repository {
    private final Map<String, Task> taskById;

    /**
     * Instantiates a new Repository.
     */
    public RepositoryImpl() {
        taskById = new HashMap<>();
//        Task task;
//        String id;
//
//        id = UUID.randomUUID().toString();
//        task = new Task(id, "text-1", TaskStatus.DONE.getStatus());
//        taskById.put(id, task);
//
//        id = UUID.randomUUID().toString();
//        task = new Task(id, "text-2", TaskStatus.DONE.getStatus());
//        taskById.put(id, task);
//
//        id = UUID.randomUUID().toString();
//        task = new Task(id, "text-3", TaskStatus.DONE.getStatus());
//        taskById.put(id, task);
//
//        id = UUID.randomUUID().toString();
//        task = new Task(id, "text-4", TaskStatus.INBOX.getStatus());
//        taskById.put(id, task);
//
//        id = UUID.randomUUID().toString();
//        task = new Task(id, "text-5", TaskStatus.INBOX.getStatus());
//        taskById.put(id, task);

    }

    /**
     *
     * @param task the task
     * @return id
     */
    public String addTask(final Task task) {
        String id = UUID.randomUUID().toString();
        taskById.put(id, task);
        task.setId(id);
        return id;
    }


    /**
     *
     * @param id the id
     * @return boolean
     */
    public boolean deleteTask(final String id) {
        return taskById.remove(id) != null;
    }

    @Override
    public Collection<Task> getAllTasks() {
        return taskById.values();
    }

    @Override
    public Task getTaskById(final String id) {
        return taskById.get(id);
    }
}
