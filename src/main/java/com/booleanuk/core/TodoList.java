package com.booleanuk.core;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TodoList {
    private List<Todo> todos = new ArrayList<>();

    public TodoList() {
        this.todos = new ArrayList<>();
        
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void addTodo(int id, String description, Boolean isComplete) {
        Todo todo = new Todo(id, description, isComplete);
        todos.add(todo);
    }

    public List<Todo> getCompleteTodos() {
        List<Todo> completeTodos = new ArrayList<>();
        for (Todo todo : todos) {
            if (todo.isComplete()) {
                completeTodos.add(todo);
            }
        }
        return completeTodos;
    }

    public List<Todo> getIncompleteTodos() {
        List<Todo> incompleteTodos = new ArrayList<>();
        for (Todo todo : todos) {
            if (!todo.isComplete()) {
                incompleteTodos.add(todo);
            }
        }
        return incompleteTodos;
    }

    public Todo getTodoById(int id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    public void removeTodoById(int id) {
        Todo todoToRemove = getTodoById(id);
        if (todoToRemove != null) {
            todos.remove(todoToRemove);
        }
    }

    public List<Todo> getTodosByAscendingName() {
        todos.sort((todo1, todo2) -> todo1.getDescription().compareTo(todo2.getDescription()));
        return todos;
    }

    public List<Todo> getTodosByDescendingName() {
        todos.sort((todo1, todo2) -> todo2.getDescription().compareTo(todo1.getDescription()));
        return todos;
    }

    public List<Todo> findTodosByName(String name) {
        List<Todo> foundTodos = new ArrayList<>();
        for (Todo todo : todos) {
            if (todo.getDescription().toLowerCase().contains(name.toLowerCase())) {
                foundTodos.add(todo);
            }
        }
        if (foundTodos.isEmpty()) {
            throw new NoSuchElementException("No todos found with the given name: " + name);
        }
        return foundTodos;
    }

    public void markTodoComplete(int id) {
        Todo todo = getTodoById(id);
        if (todo != null) {
            todo.setComplete(true);
        }
    }

    public void markTodoIncomplete(int id) {
        Todo todo = getTodoById(id);
        if (todo != null) {
            todo.markIncomplete();
        }
    }

        
}
