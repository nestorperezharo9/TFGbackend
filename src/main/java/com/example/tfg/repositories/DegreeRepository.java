package com.example.tfg.repositories;

import com.example.tfg.model.Degree;

public class DegreeRepository extends Repository<Degree> {

    public DegreeRepository() {
        super("TFG", "degrees", Degree.class);
    }
}
