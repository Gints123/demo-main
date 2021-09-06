package org.company.tms.services.impl;


import org.company.tms.models.Task;
import org.company.tms.repositories.TaskRepository;
import org.company.tms.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List getAllTasks() {
        List tasks = new ArrayList();
        taskRepository.findAll().forEach(task -> tasks.add(task));
        return tasks;
    }

    public Task getTaskById(int id) {
        return taskRepository.findById(id).get();
    }

    public void saveOrUpdate(Task task){
        taskRepository.save(task);
    }
    public void delete(int id){
        taskRepository.deleteById(id);
    }
}
