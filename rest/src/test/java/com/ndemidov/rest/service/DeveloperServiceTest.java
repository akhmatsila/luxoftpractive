package com.ndemidov.rest.service;

import com.ndemidov.rest.dao.DeveloperDao;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class DeveloperServiceTest {
    @Mock
    private DeveloperDao developerDao;

    @InjectMocks
    private DeveloperService developerService;


    @Test
    void addDeveloper() {

    }

    @Test
    void getDeveloperById() {
    }

    @Test
    void getAll() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void deleteById() {
    }
}