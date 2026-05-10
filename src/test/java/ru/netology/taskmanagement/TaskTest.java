package ru.netology.taskmanagement;

import ru.netology.taskmanagement.entities.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.taskmanagement.service.TaskService;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    private TaskService taskService;

    @BeforeEach
    void setUp(){
        taskService = new TaskService();
    }
    @Test
    void createTaskTest(){
        Task task = taskService.create("купить хлеб");
        assertEquals("купить хлеб",task.getTitle());
        assertFalse(task.getCompleted());
    }

    @Test
    void findAllTest(){
        taskService.create("купить  хлеб");
        taskService.create("купить молоко");
        assertEquals(2,taskService.findAll().size());
    }

    @Test
   void updateTaskTest(){
        Task task = taskService.create("Купить хлеб");
        Task updateTask = taskService.update(task.getId(),"купить молоко",true);
        assertEquals("купить молоко",updateTask.getTitle());
        assertTrue(updateTask.getCompleted());
    }

    @Test
    void deleteTaskTest(){
        Task task = taskService.create("купить хлеб");
        taskService.delete(task.getId());
        assertEquals(0,taskService.findAll().size());

    }


}
