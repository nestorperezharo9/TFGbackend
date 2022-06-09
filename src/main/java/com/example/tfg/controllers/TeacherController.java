package com.example.tfg.controllers;

import com.example.tfg.model.New;
import com.example.tfg.model.Teacher;
import com.example.tfg.repositories.TeacherRepository;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/teachers/directive")
    public List<Teacher> getTeacherByPosition() {
        return this.teacherRepository.findAll();
    }

    @PostMapping("/teachers/teacher/create")
    public void createTeacher(@RequestBody Teacher teacher) {
        this.teacherRepository.insertOne(teacher);
    }

    @GetMapping("/teachers/delete/{id}")
    public void deleteTeacher(@PathVariable("id") String id) {
        this.teacherRepository.deleteOne(id);
    }

}