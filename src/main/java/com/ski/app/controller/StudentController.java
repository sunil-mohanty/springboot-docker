
package com.ski.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ski.app.model.Student;
import com.ski.app.repository.StudentRepository;



@RestController
public class StudentController {

    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody List<Student> students) {
        studentRepository.saveAll(students);
    }

    @GetMapping("/students")
    public ResponseEntity<Object> getStudent() {
    	Map<String, Object> response = new HashMap<>();
    	response.put("students", studentRepository.findAll());
    	return ResponseEntity.ok(response);
         
    }
}
