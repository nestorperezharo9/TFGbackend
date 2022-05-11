package com.example.tfg.repositories;

import com.example.tfg.model.Doctorate;

public class DoctorateRepository extends Repository<Doctorate> {

    public DoctorateRepository() { super("TFG", "doctorates", Doctorate.class); }
}
