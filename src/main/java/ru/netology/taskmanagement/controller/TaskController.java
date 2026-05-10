package ru.netology.taskmanagement.controller;

import ru.netology.taskmanagement.entities.Task;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.taskmanagement.service.TaskService;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> create( @RequestBody Task task){
        return ResponseEntity.ok(taskService.create(task.getTitle()));
    }

@GetMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task task){
        return ResponseEntity.ok(taskService.update(id,task.getTitle(), task.getCompleted()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
