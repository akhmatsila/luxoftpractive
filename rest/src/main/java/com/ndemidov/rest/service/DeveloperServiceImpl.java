package com.ndemidov.rest.service;

import com.ndemidov.rest.dao.DeveloperDao;
import com.ndemidov.rest.model.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DeveloperServiceImpl implements DeveloperService {
    private final DeveloperDao developerDao;

    @Autowired
    public DeveloperServiceImpl(DeveloperDao developerDao) {
        this.developerDao = developerDao;
    }

    @Override
    @Transactional
    public void saveDeveloper(Developer developer) {
        developer.setId(0);
        developerDao.save(developer);
    }

    @Override
    @Transactional
    public void updateDeveloper(Developer developer) {
        developerDao.save(developer);
    }

    @Override
    @Transactional
    public Developer getDeveloperById(int id) {
        return developerDao.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    @Transactional
    public List<Developer> getAll() {
        return developerDao.findAll();
    }

    @Override
    @Transactional
    public void deleteAll() {
        developerDao.deleteAll();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        developerDao.deleteById(id);
    }
}
