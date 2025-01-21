package com.webtech.web.tech.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webtech.web.tech.Model.Student;
import com.webtech.web.tech.Service.UserService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {
    
    private final UserService userService;

    public StudentController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public List<Student> getStudentsList() {
        return userService.getStudents();
    }
    
    @GetMapping("/{id}")
    public String getStudentById(@RequestParam Integer id) {
        return userService.getStudent(id).toString();
    }

    @PostMapping("/")
    public boolean createStudent(@RequestBody Student param) {        
        return userService.addStudent(param);
    }

    @PutMapping("/{id}")
    public String putMethodName(@PathVariable String id, @RequestBody String entity) {
        return entity;
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@RequestParam Integer id){
        userService.deleteStudent(id);
    }
    
}
