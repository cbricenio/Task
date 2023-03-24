package com.bootcamp.Task.repository;

import com.bootcamp.Task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // for other end point
    public Task findByTitle(String taskTitle);
    public Task findByTitleIgnoreCase(String taskTitle);
}
