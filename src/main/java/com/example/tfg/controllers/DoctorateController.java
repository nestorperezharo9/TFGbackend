package com.example.tfg.controllers;

import com.example.tfg.model.Doctorate;
import com.example.tfg.repositories.DoctorateRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DoctorateController {

    private final DoctorateRepository repository = new DoctorateRepository();

    @GetMapping("/doctorates/all")
    public List<Doctorate> getAllDoctorates() {
        return this.repository.findAll();
    }
}