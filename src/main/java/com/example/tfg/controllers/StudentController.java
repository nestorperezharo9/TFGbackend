package com.example.tfg.controllers;

import com.example.tfg.model.Student;
import com.example.tfg.repositories.StudentRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    private final StudentRepository studentRepository = new StudentRepository();

    @GetMapping("/students/all")
    public List<Student> getAllTeachers() {
            return this.studentRepository.findAll();
        }
}
