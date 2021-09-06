package org.company.tms.services;


import org.company.tms.models.Task;

import java.util.List;

public interface TaskService {
    public List getAllTasks();

    public Task getTaskById(int id);

    public void saveOrUpdate(Task task);
    public void delete(int id);
}
