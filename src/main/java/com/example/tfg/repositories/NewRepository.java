package com.example.tfg.repositories;

import com.example.tfg.model.New;

public class NewRepository extends Repository<New> {

    public NewRepository() {
        super("TFG", "news", New.class);
    }
}
