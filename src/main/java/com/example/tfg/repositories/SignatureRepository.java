package com.example.tfg.repositories;

import com.example.tfg.model.Signature;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class SignatureRepository extends Repository<Signature> {

    public SignatureRepository() {
        super("TFG", "signatures", Signature.class);
    }

    public List<Signature> findByCourseId(String courseId) {
        List<Signature> signatures = new ArrayList<>();
        super.collection.find(eq("courseId", courseId)).forEach(signatures::add);
        return signatures;
    }

}
