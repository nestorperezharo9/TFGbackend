package com.example.tfg.controllers;

import com.example.tfg.model.User;
import com.example.tfg.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserRepository repository = new UserRepository();

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return this.repository.findAll();
    }

    @PostMapping("/login")
    public boolean login(@RequestBody User user) {
        return this.repository.login(user);
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
