package com.example.tfg.repositories;

import com.example.tfg.model.Room;

public class RoomRepository extends Repository<Room>{

    public RoomRepository() {
        super("TFG", "rooms", Room.class);
    }
}
