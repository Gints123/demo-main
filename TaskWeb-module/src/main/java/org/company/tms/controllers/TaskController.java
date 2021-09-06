package org.company.tms.controllers;


import org.company.tms.models.Task;
import org.company.tms.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/tasks")
    private List getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks/{id}")
    private Task getTask(@PathVariable("id") int id){
        return taskService.getTaskById(id);
    }


    @DeleteMapping("/tasks/{id}")
    private void deleteTask(@PathVariable("id") int id){
        taskService.delete(id);
    }

    @PostMapping("/tasks")
    private int saveTask(@RequestBody Task task){
        taskService.saveOrUpdate(task);
        return task.getTask_id();
    }

    @PutMapping("/tasks/{id}")
    private Task updTask(@PathVariable("id") int id, @RequestBody Task task) {
        taskService.getTaskById(id);
        task.setTitle(task.getTitle());
        task.setWorker(task.getWorker());
        task.setTime_spent(task.getTime_spent());
        taskService.saveOrUpdate(task);
        return taskService.getTaskById(id);
    }
}
