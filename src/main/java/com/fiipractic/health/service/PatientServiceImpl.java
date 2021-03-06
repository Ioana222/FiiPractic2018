package com.fiipractic.health.service;

import com.fiipractic.health.db.HealthDB;
import com.fiipractic.health.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private HealthDB healthDB;

    @Autowired
    public PatientServiceImpl(HealthDB healthDB){
        this.healthDB = healthDB;
    }

    @Override
    public List<Patient> getPatients() {
        return healthDB.getPatients();
    }

    @Override
    public Patient getPatient(Long id) {
        return healthDB.getPatient(id);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return healthDB.updatePatient(patient);
    }

    @Override
    public void deletePatient(Patient patient) {
        healthDB.deletePatient(patient);
    }

    @Override
    public Patient savePatient(Patient patient){
        return healthDB.savePatient(patient);
    }

}
