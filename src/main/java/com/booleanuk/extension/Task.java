package com.booleanuk.extension;
import java.time.LocalDateTime;

public class Task {
    private int id;
    private String name;
    private String description;
    private LocalDateTime createdtimestamp;
    private boolean isComplete;

    public Task(int id, String name, String description, LocalDateTime createdtimestamp, boolean isComplete) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdtimestamp = createdtimestamp;
        this.isComplete = isComplete;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedtimestamp() {
        return createdtimestamp;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }
}
