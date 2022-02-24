package com.ndemidov.rest.dao;

import com.ndemidov.rest.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskDao extends JpaRepository<Task, Integer> {
    public Optional<List<Task>> findAllByDeveloperId(int developerId);

    public void deleteAllByDeveloperId(int developerId);
}
