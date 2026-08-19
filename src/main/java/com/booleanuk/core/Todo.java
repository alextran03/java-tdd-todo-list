package com.booleanuk.core;

public class Todo {
    private int id;
    private String description;
    private Boolean isComplete;

    public Todo(int id, String description, Boolean isComplete) {
        this.id = id;
        this.description = description;
        this.isComplete = isComplete;
    }

    public Boolean isComplete() {
        return isComplete;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

    public void markIncomplete() {
        isComplete = false;
    }
    
}
