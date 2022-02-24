package com.ndemidov.rest.controller;

import com.ndemidov.rest.dao.TestDao;
import com.ndemidov.rest.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    private TestDao testDao;

    public List<Test> test() {
        return testDao.findAll();
    }
}
