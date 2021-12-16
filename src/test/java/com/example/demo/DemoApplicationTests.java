package com.example.demo;

import com.example.demo.rest.model.Movie;
import com.example.demo.rest.service.MoviesRestService;
import com.example.demo.service.ApplicationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.IOException;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    MoviesRestService moviesRestService;

    @Autowired
    ApplicationService applicationService;

    @Test
    void contextLoads() {
    }
    @Test
    public void test() throws IOException {
        Movie movieById = moviesRestService.getMovieById("200");
    }
    @Test
    public void test2() throws IOException {
        applicationService.Task2();
    }

    @Test
    void test1(){

    }


}
