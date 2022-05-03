package com.example.tfg.repositories;

import com.example.tfg.model.User;

import java.util.List;

public class UserRepository extends Repository<User>{

    public UserRepository() {
        super("TFG", "users", User.class);
    }

    public void registerUser(User newUser) {
        if (!existUser(newUser.getIdentifier())) {
            this.insertOne(newUser);
        }
    }

    public boolean login(User user) {
        return existUser(user.getIdentifier());
    }

    public void deleteUser(String id) {
        if (existUser(id)) {
            this.deleteOne(id);
        }
    }

    private boolean existUser(String id) {
        List<User> users = this.findAll();
        return users.stream().filter(user -> user.getIdentifier().equals(id)).toList().size() != 0;
    }
}
