package com.example.tfg.controllers;

import com.example.tfg.model.Teacher;
import com.example.tfg.repositories.TeacherRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TeacherController {

    private final TeacherRepository teacherRepository = new TeacherRepository();

    @GetMapping("/teachers/all")
    public List<Teacher> getAllTeachers() {
        return this.teacherRepository.findAll();
    }

    @GetMapping("/teachers/{id}")
    public Teacher getTeacherById(@PathVariable("id") String id) {
        return this.teacherRepository.findOne(id);
    }
}