package com.example.tfg.model;

import org.mongojack.Id;

public class Signature {

    @Id
    private String id;
    private String degreeId;
    private Integer code;
    private String name;
    private Integer plan;
    private Specialty specialty;
    private String school;
    private Department department;
    private SignatureType type;
    private SignatureCharacter character;
    private Integer duration;
    private Integer credits;
    private Integer course;
    private String teachingProject;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(String degreeId) {
        this.degreeId = degreeId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPlan() {
        return plan;
    }

    public void setPlan(Integer plan) {
        this.plan = plan;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public SignatureType getType() {
        return type;
    }

    public void setType(SignatureType type) {
        this.type = type;
    }

    public SignatureCharacter getCharacter() {
        return character;
    }

    public void setCharacter(SignatureCharacter character) {
        this.character = character;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public String getTeachingProject() {
        return teachingProject;
    }

    public void setTeachingProject(String teachingProject) {
        this.teachingProject = teachingProject;
    }
}
