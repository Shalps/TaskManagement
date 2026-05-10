package ru.netology.taskmanagement.service;

import ru.netology.taskmanagement.entities.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
@Service
public class TaskService {
    private final Map<Long, Task> tasks = new ConcurrentHashMap<>();
    AtomicLong counter = new AtomicLong(1);

    public Task create(String title){
        long id = counter.getAndIncrement();
        Task task = new Task(id,title,false, LocalDate.now());
         tasks.put(id,task);
         return task;
    }

    public List<Task> findAll(){
        return new ArrayList<>(tasks.values());
    }

    public Task update(Long id,String title,Boolean completed){
        Task task = tasks.get(id);
        if (task==null){
            throw new NoSuchElementException("задача не найдена");
        }
        if (title!=null){
            task.setTitle(title);
        }
        if (completed!=null){
            task.setCompleted(completed);
        }
        return task;
    }
    public void delete(long id){
        if (tasks.remove(id)==null){
            throw new NoSuchElementException("задача не найдена");
        }
        tasks.remove(id);
    }
}
