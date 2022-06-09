package com.example.tfg.controllers;

import com.example.tfg.model.Degree;
import com.example.tfg.model.Master;
import com.example.tfg.repositories.MasterRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MasterController {

    private final MasterRepository repository = new MasterRepository();

    @GetMapping("/masters/all")
    public List<Master> getAllMasters() {
        return this.repository.findAll();
    }

    @PostMapping("/masters/create")
    public void createMaster(@RequestBody Master master) {
        this.repository.insertOne(master);
    }

    @GetMapping("/masters/delete/{id}")
    public void deleteTeacher(@PathVariable("id") String id) {
        this.repository.deleteOne(id);
    }
}

