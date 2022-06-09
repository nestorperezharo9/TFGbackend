package com.example.tfg.repositories;

import com.example.tfg.model.User;

import java.util.List;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

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
        return existUserPsw(user.getIdentifier(), user.getPassword());
    }

    public void deleteUser(String id) {
        if (existUser(id)) {
            this.deleteOne(id);
        }
    }

    private boolean existUserPsw(String id, String psw) {
        User user = this.collection.find(and(eq("_id", id), eq("password", psw))).first();
        return user != null;
    }

    private boolean existUser(String id) {
        List<User> users = this.findAll();
        return users.stream().filter(user -> user.getIdentifier().equals(id)).toList().size() != 0;
    }
}
