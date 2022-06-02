package com.example.tfg.controllers;

import com.example.tfg.model.New;
import com.example.tfg.repositories.NewRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class NewController {

    private final NewRepository newRepository = new NewRepository();

    @GetMapping("/news/all")
    public List<New> getAllNews() {
        return this.newRepository.findAll();
    }
}
