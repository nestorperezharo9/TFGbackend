package com.example.tfg.controllers;

import com.example.tfg.model.Signature;
import com.example.tfg.repositories.SignatureRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SignatureController {

    private final SignatureRepository signatureRepository = new SignatureRepository();

    @GetMapping("/signatures/all")
    public List<Signature> getAllSignatures() {
        return this.signatureRepository.findAll();
    }

    @GetMapping("/signatures/course/{courseId}")
    public List<Signature> getSignaturesByCourseId(@PathVariable("courseId") String courseId) {
        return this.signatureRepository.findByCourseId(courseId);
    }

    @GetMapping("/signatures/{id}")
    public Signature getSignatureById(@PathVariable("id") String id) {
        return this.signatureRepository.findOne(id);
    }
}
