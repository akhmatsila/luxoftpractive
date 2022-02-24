package com.ndemidov.rest.controller;

import com.ndemidov.rest.model.Developer;
import com.ndemidov.rest.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/developer")
public class DeveloperController {
    private final DeveloperService developerService;

    @Autowired
    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping
    public List<Developer> getAll() {
        return developerService.getAll();
    }

    @GetMapping("/{id}")
    public Developer getById(@PathVariable(name = "id") int id) {
        try {
            return developerService.getDeveloperById(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public void add(@RequestBody Developer developer) {
        developer.setId(0);
        this.developerService.saveDeveloper(developer);
    }

    @PutMapping
    public void update(@RequestBody Developer developer) {
        this.developerService.updateDeveloper(developer);
    }

    @DeleteMapping
    public void deleteAll() {
        this.developerService.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        this.developerService.deleteById(id);
    }
}
