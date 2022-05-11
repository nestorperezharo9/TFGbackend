package com.example.tfg.controllers;

import com.example.tfg.model.Master;
import com.example.tfg.repositories.MasterRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MasterController {

    private final MasterRepository repository = new MasterRepository();

    @GetMapping("/masters/all")
    public List<Master> getAllMasters() {
        return this.repository.findAll();
    }
}

