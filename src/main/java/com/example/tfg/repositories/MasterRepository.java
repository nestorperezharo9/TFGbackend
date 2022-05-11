package com.example.tfg.repositories;

import com.example.tfg.model.Master;

public class MasterRepository extends Repository<Master>{

    public MasterRepository() { super("TFG", "masters", Master.class); }

}
