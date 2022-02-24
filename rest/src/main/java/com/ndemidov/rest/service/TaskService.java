package com.ndemidov.rest.service;

import com.ndemidov.rest.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TaskService {
    public List<Task> findAllByDeveloperId(int developerId);

    public void deleteAllByDeveloperId(int developerId);

    public void saveTask(Task task);

    public void updateTask(Task task);
}
