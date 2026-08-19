package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.NoSuchElementException;

class TodoListTest {
    @Test
    void createTodoList() {
        TodoList todoList = new TodoList();
        Assertions.assertNotNull(todoList);
    }

    @Test
    void getTodos() {
        TodoList todoList = new TodoList();
        Assertions.assertNotNull(todoList.getTodos());
    }

    @Test
    void addTodo() {
        TodoList todoList = new TodoList();
        todoList.addTodo(1, "Test", true);
        todoList.addTodo(2, "Test 2", false);
        todoList.addTodo(3, "Test 3", true);
        Assertions.assertEquals(3, todoList.getTodos().size());
    }

    @Test
    void completeTodo() {
        TodoList todoList = new TodoList();
        todoList.addTodo(1, "Test", true);
        Assertions.assertTrue(todoList.getTodos().get(0).isComplete());
    }

    @Test 
    void incompleteTodo() {
        TodoList todolist = new TodoList();
        todolist.addTodo(1, "Test", false);
        Assertions.assertFalse(todolist.getTodos().get(0).isComplete());
    }

    @Test
    void getCompleteTodos() {
        TodoList todoList = new TodoList();
        todoList.addTodo(1, "Test", true);
        todoList.addTodo(2, "Test 2", false);
        todoList.addTodo(3, "Test 3", true);
        Assertions.assertEquals(2, todoList.getCompleteTodos().size());
    }

    @Test
    void getIncompleteTodos() {
        TodoList todoList = new TodoList();
        todoList.addTodo(1, "Test", true);
        todoList.addTodo(2, "Test 2", false);
        todoList.addTodo(3, "Test 3", true);
        Assertions.assertEquals(1, todoList.getIncompleteTodos().size());
    }

    @Test
    void findTodoById() {
        TodoList todoList = new TodoList();
        todoList.addTodo(1, "Test", true);
        Assertions.assertEquals(1, todoList.getTodoById(1).getId());
    }

    @Test
    void findTodosByName() {
        TodoList todoList = new TodoList();
        todoList.addTodo(1, "Pasta Bolognese", false);
        todoList.addTodo(2, "Pasta Carbonara", false);
        todoList.addTodo(3, "Pasta pesto", false);
        todoList.addTodo(4, "Pizza Margherita", false);

        List<Todo> found = todoList.findTodosByName("Pasta");
        Assertions.assertEquals(3, found.size());
    }

    @Test
    void removeTodoById() {
        TodoList todoList = new TodoList();
        todoList.addTodo(1, "Test", true);
        todoList.removeTodoById(1);
        Assertions.assertEquals(0, todoList.getTodos().size());
        
    }

    @Test
    void getTodosByAscendingName() {
        TodoList todoList = new TodoList();
        todoList.addTodo(1, "Test", true);
        todoList.addTodo(2, "Test 2", false);
        todoList.addTodo(3, "Test 3", true);
        Assertions.assertEquals("Test", todoList.getTodosByAscendingName().get(0).getDescription());
    }

    @Test
    void getTodosByDescendingName() {
        TodoList todoList = new TodoList();

        todoList.addTodo(1, "Test", true);
        todoList.addTodo(2, "Test 2", false);
        todoList.addTodo(3, "Test 3", true);
        Assertions.assertEquals("Test 3", todoList.getTodosByDescendingName().get(0).getDescription());
    }

    @Test
    void MarkTodoAsIncomplete() {
        TodoList todoList = new TodoList();
        todoList.addTodo(1, "Test", true);
        todoList.markTodoIncomplete(1);
        Assertions.assertFalse(todoList.getTodoById(1).isComplete());
    }

    @Test
    void MarkTodoAsComplete() {
        TodoList todoList = new TodoList();
        todoList.addTodo(1, "Test", false);
        todoList.markTodoComplete(1);
        Assertions.assertTrue(todoList.getTodoById(1).isComplete());
    }

    @Test
    void findTodosByNameNotFound() {
        TodoList todoList = new TodoList();
        todoList.addTodo(1, "Pasta Bolognese", false);
        todoList.addTodo(2, "Pasta Carbonara", false);
        todoList.addTodo(3, "Pasta pesto", false);
        todoList.addTodo(4, "Pizza Margherita", false);

        Exception exception = Assertions.assertThrows(NoSuchElementException.class, () -> {
            todoList.findTodosByName("Burger");
        });

        Assertions.assertEquals("No todos found with the given name: Burger", exception.getMessage());
    }

}
