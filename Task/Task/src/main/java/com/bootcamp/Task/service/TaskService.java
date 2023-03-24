package com.bootcamp.Task.service;

import com.bootcamp.Task.model.Task;

import java.util.List;

public interface TaskService {
    public Task saveTask(Task task);

    public List<Task> fetchTaskList();

    public Task fetchTaskById(Long taskId);

    public void deleteTaskById(Long taskId);

    public Task updateTask(Long taskId, Task task);

}
