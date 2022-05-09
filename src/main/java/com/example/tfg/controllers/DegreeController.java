package com.example.tfg.controllers;

import com.example.tfg.model.Degree;
import com.example.tfg.repositories.DegreeRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DegreeController {

    private final DegreeRepository repository = new DegreeRepository();

    @GetMapping("/degrees/all")
    public List<Degree> getAllDegrees() {
        return this.repository.findAll();
    }
}
