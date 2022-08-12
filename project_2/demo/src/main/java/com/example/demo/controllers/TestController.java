package com.example.demo.controllers;

import com.example.demo.services.OMDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private OMDBService s;

    @GetMapping("/test")
    public ResponseEntity test(){
        s.getMoviesByTitle("avatar");
        return ResponseEntity.ok(s);
    }
}
