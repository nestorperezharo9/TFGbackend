package com.example.tfg.repositories;

import com.example.tfg.model.Signature;

public class SignatureRepository extends Repository<Signature> {

    public SignatureRepository() {
        super("TFG", "signatures", Signature.class);
    }
}
