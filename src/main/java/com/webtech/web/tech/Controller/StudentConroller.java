package com.webtech.web.tech.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/student")
public class StudentConroller {
    @GetMapping("/")
    public String getStudentsList(@RequestParam String param) {
        return new String();
    }
    @GetMapping("/{id}")
    public String getStudentById(@RequestParam String param) {
        return new String();
    }
    @PostMapping("/")
    public String createStudent(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    @PutMapping("/{id}")
    public String putMethodName(@PathVariable String id, @RequestBody String entity) {
        //TODO: process PUT request
        
        return entity;
    }
    @DeleteMapping("/{id}")
    public String 
    
}
