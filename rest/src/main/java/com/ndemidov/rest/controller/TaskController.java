package com.ndemidov.rest.controller;

import com.ndemidov.rest.model.Task;
import com.ndemidov.rest.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService service) {
        this.taskService = service;
    }

    @GetMapping("/{developer_id}")
    public List<Task> getAllByDeveloperId(@PathVariable("developer_id") int developerId) {
        try {
            return taskService.findAllByDeveloperId(developerId);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public void postTask(@RequestBody Task task) {
        System.out.println(task.getDeveloper());
        System.out.println(task.getId());
        System.out.println(task.getTodo());
        taskService.saveTask(task);
    }

    @PutMapping
    public void updateTask(@RequestBody Task task) {
        taskService.updateTask(task);
    }

    @DeleteMapping("/{developer_id}")
    public void deleteTasksByDeveloperId(@PathVariable(name = "developer_id") int developerId) {
        taskService.deleteAllByDeveloperId(developerId);
    }
}
