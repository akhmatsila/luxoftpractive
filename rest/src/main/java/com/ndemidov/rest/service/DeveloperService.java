package com.ndemidov.rest.service;

import com.ndemidov.rest.model.Developer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DeveloperService {
    public void saveDeveloper(Developer developer);

    public void updateDeveloper(Developer developer);

    public Developer getDeveloperById(int id);

    public List<Developer> getAll();

    public void deleteAll();

    public void deleteById(int id);

}
