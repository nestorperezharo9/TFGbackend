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
        return existUserPsw(user.getIdentifier(), user.getPassword());
    }

    public void deleteUser(String id) {
        if (existUser(id)) {
            this.deleteOne(id);
        }
    }

    private boolean existUserPsw(String id, String psw) {
        List<User> users = this.findAll();
        boolean name = users.stream().filter(user -> user.getIdentifier().equals(id)).toList().size() != 0;
        boolean pass = users.stream().filter(user -> user.getPassword().equals(psw)).toList().size() != 0;
        if(name && pass) {
            return true;
        } else {
            return false;
        }
    }

    private boolean existUser(String id) {
        List<User> users = this.findAll();
        return users.stream().filter(user -> user.getIdentifier().equals(id)).toList().size() != 0;
    }
}
