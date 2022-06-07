package com.example.tfg.controllers;

import com.example.tfg.model.New;
import com.example.tfg.repositories.NewRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class NewController {

    private final NewRepository newRepository = new NewRepository();

    @GetMapping("/news/all")
    public List<New> getAllNews() {
        return this.newRepository.findAllReverse();
    }

    @PostMapping("/news/create")
    public void createNew(@RequestBody New news) {
        this.newRepository.insertOne(news);
    }

    @GetMapping("/news/delete/{id}")
    public void deleteNew(@PathVariable("id") String id) {
        this.newRepository.deleteOne(id);
    }
}
