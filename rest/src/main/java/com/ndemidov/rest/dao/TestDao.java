package com.ndemidov.rest.dao;

import com.ndemidov.rest.model.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestDao extends CrudRepository<Test, Integer> {
    public List<Test> findAll();
}
