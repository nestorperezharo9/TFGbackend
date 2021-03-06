package com.example.tfg.controllers;

import com.example.tfg.model.User;
import com.example.tfg.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserRepository repository = new UserRepository();

    @GetMapping("/users/all")
    public List<User> getAllUsers() {
        return this.repository.findAll();
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
         if (this.repository.login(user)) {
            return this.repository.findOne(user.getIdentifier());
        }
        return null;
    }
    
    @PostMapping("/register")
    public void register(@RequestBody User user) {
        user.setRoles(List.of("USER"));
        this.repository.registerUser(user);
    }

    @DeleteMapping("/unsubscribe/{id}")
    public void unsubscribe(@PathVariable String id) {
        this.repository.deleteUser(id);
    }
}
