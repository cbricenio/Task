package com.bootcamp.Task.service;

import com.bootcamp.Task.model.Task;
import com.bootcamp.Task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> fetchTaskList() {
        return taskRepository.findAll();
    }

    @Override
    public Task fetchTaskById(Long taskId) {
        return taskRepository.findById(taskId).get();
    }

    @Override
    public void deleteTaskById(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public Task updateTask(Long taskId, Task task) {
        Task taskDb = taskRepository.findById(taskId).get();
        if(Objects.nonNull(task.getTitle()) && !"".equalsIgnoreCase(task.getTitle())){
            taskDb.setTitle(task.getTitle());
        }
        if(Objects.nonNull(task.getDescription()) && !"".equalsIgnoreCase(task.getDescription())){
            taskDb.setDescription(task.getDescription());
        }
        if(Objects.nonNull(task.getCompleted()) && !"".equalsIgnoreCase(task.getCompleted())){
            taskDb.setCompleted(task.getCompleted());
        }
        return taskRepository.save(taskDb);
    }
}
