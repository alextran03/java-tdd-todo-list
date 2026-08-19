package com.booleanuk.extension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskListTest {

    @Test
    void createTaskList() {
        TaskList taskList = new TaskList();
        Assertions.assertNotNull(taskList);
    }

    @Test
    void getTasks() {
        TaskList taskList = new TaskList();
        Assertions.assertNotNull(taskList.getTasks());
    }

    @Test
    void getTasksById() {
        TaskList taskList = new TaskList();
        taskList.addTask(1, "Test", "Test description", true);
        taskList.addTask(2, "Test 2", "Test description 2", false);
        taskList.addTask(3, "Test 3", "Test description 3", true);
        Assertions.assertEquals("Test 2", taskList.getTaskById(2).getName());
    }

    @Test
    void addTask() {
        TaskList taskList = new TaskList();
        taskList.addTask(1, "Test", "Test description", true);
        taskList.addTask(2, "Test 2", "Test description 2", false);
        taskList.addTask(3, "Test 3", "Test description 3", true);
        Assertions.assertEquals(3, taskList.getTasks().size());
    }

    @Test
    void removeTask() {
        TaskList taskList = new TaskList();
        taskList.addTask(1, "Test", "Test description", true);
        taskList.removeTaskById(1);
        Assertions.assertEquals(0, taskList.getTasks().size());
    }

    @Test
    void updateTask() {
        TaskList taskList = new TaskList();
        taskList.addTask(1, "Test", "Test description", true);
        taskList.updateTask(1, "Updated Test", "Updated description");
        Assertions.assertEquals("Updated Test", taskList.getTaskById(1).getName());
        Assertions.assertEquals("Updated description", taskList.getTaskById(1).getDescription());
    }

    @Test
    void changeStatusById() {
        TaskList taskList = new TaskList();
        taskList.addTask(1, "Test", "Test description", false);
        taskList.changeStatusById(1, true);
        Assertions.assertTrue(taskList.getTaskById(1).isComplete());    
    }

    @Test
    void checkDateAndTimeStampForTask() {
        TaskList taskList = new TaskList();
        taskList.addTask(1, "Test", "Test description", false);
        Assertions.assertNotNull(taskList.getTaskById(1).getCreatedtimestamp());
    }


}
