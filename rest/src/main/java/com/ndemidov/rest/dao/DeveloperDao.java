package com.ndemidov.rest.dao;

import com.ndemidov.rest.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeveloperDao extends JpaRepository<Developer, Integer> {
}
