package com.example.tfg.repositories;

import com.example.tfg.model.Student;

public class StudentRepository extends Repository<Student>{

    public StudentRepository() { super("TFG", "students", Student.class); }
}
