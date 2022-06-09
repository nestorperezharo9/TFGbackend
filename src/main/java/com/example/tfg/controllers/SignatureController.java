package com.example.tfg.controllers;

import com.example.tfg.model.Signature;
import com.example.tfg.repositories.SignatureRepository;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/degrees/signature/create")
    public void createSignatureDegree(@RequestBody Signature signature) {
        this.signatureRepository.insertOne(signature);
    }

    @PostMapping("/masters/signature/create")
    public void createSignatureMaster(@RequestBody Signature signature) {
        this.signatureRepository.insertOne(signature);
    }

    @PostMapping("/doctorate/signature/create")
    public void createSignatureDoctorate(@RequestBody Signature signature) {
        this.signatureRepository.insertOne(signature);
    }

    @GetMapping("/signatures/delete/{id}")
    public void deleteSignature(@PathVariable("id") String id) {
        this.signatureRepository.deleteOne(id);
    }
}
