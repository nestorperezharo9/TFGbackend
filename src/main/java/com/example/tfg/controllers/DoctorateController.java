package com.example.tfg.controllers;

import com.example.tfg.model.Degree;
import com.example.tfg.model.Doctorate;
import com.example.tfg.repositories.DoctorateRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DoctorateController {

    private final DoctorateRepository repository = new DoctorateRepository();

    @GetMapping("/doctorates/all")
    public List<Doctorate> getAllDoctorates() {
        return this.repository.findAll();
    }

    @PostMapping("/doctorates/create")
    public void createDoctorates(@RequestBody Doctorate doctorate) {
        this.repository.insertOne(doctorate);
    }

    @GetMapping("/doctorates/delete/{id}")
    public void deleteTeacher(@PathVariable("id") String id) {
        this.repository.deleteOne(id);
    }

}