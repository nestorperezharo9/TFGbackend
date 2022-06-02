package com.example.tfg.controllers;

import com.example.tfg.model.Room;
import com.example.tfg.repositories.RoomRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {

    private final RoomRepository roomRepository = new RoomRepository();

    @GetMapping("/rooms/all")
    public List<Room> getAllRooms() {
        return this.roomRepository.findAll();
    }

    @GetMapping("/rooms/{id}")
    public Room getRoomById(@PathVariable("id") String id) {
        return this.roomRepository.findOne(id);
    }
}
