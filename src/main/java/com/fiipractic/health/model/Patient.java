package com.fiipractic.health.model;

public class Patient {
    private Long id;
    private String name;
    private String age;
    private String malady;
    private String medicalTreatment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMalady() {
        return malady;
    }

    public void setMalady(String malady) {
        this.malady = malady;
    }

    public String getMedicalTreatment() {
        return medicalTreatment;
    }

    public void setMedicalTreatment(String medicalTreatment) {
        this.medicalTreatment = medicalTreatment;
    }
}
