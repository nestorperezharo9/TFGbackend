package com.example.tfg.repositories;

import com.example.tfg.model.Teacher;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class TeacherRepository extends Repository<Teacher>{
    public TeacherRepository() {
        super("TFG", "teachers", Teacher.class);
    }

    public List<Teacher> findByPosition(String position) {
        List<Teacher> teachers = new ArrayList<>();
        super.collection.find(eq("position", position)).forEach(teachers::add);
        return teachers;
    }
}
