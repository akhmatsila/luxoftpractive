package com.ndemidov.rest.service;

import com.ndemidov.rest.dao.TaskDao;
import com.ndemidov.rest.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class TaskServiceImpl implements TaskService{
    private final TaskDao taskDao;

    @Autowired
    public TaskServiceImpl(TaskDao dao) {
        this.taskDao = dao;
    }

    @Override
    @Transactional
    public List<Task> findAllByDeveloperId(int developerId) {
        return taskDao.findAllByDeveloperId(developerId).orElseThrow(NoSuchElementException::new);
    }

    @Override
    @Transactional
    public void deleteAllByDeveloperId(int developerId) {
        taskDao.deleteAllByDeveloperId(developerId);
    }

    @Override
    @Transactional
    public void saveTask(Task task) {
        task.setId(0);
        taskDao.save(task);
    }

    @Override
    @Transactional
    public void updateTask(Task task) {
        taskDao.save(task);
    }
}
