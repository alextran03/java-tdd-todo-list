package com.booleanuk.extension;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class TaskList {
    private List<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();  
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Task getTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public void addTask(int id, String name, String description, boolean isComplete) {
        Task task = new Task(id, name, description, LocalDateTime.now(), isComplete);
        tasks.add(task);
    }

    public void removeTaskById(int id) {
        Task taskToRemove = getTaskById(id);
        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
        }
    }

    public void updateTask(int id, String name, String description) {
        Task taskToUpdate = getTaskById(id);
        if (taskToUpdate != null) {
            taskToUpdate.setName(name);
            taskToUpdate.setDescription(description);
        }
    }
    public void changeStatusById(int id, boolean isComplete) {
        Task taskToChangeStatus = getTaskById(id);
        if (taskToChangeStatus != null) {
            taskToChangeStatus.setComplete(isComplete);
        }
    }
}
