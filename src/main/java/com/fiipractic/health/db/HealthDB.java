package com.fiipractic.health.db;

import com.fiipractic.health.model.Doctor;
import com.fiipractic.health.model.Patient;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class HealthDB {

    private Map<Long, Doctor> doctors;
    private Map<Long, Patient> patients;


    public HealthDB(){
        this.doctors = new HashMap<>();
        this.patients = new HashMap<>();
    }
    //doctor
    public List<Doctor> getDoctors(){
        return new ArrayList<Doctor>(doctors.values());
    }

    public Doctor getDoctor(Long id){
        return doctors.get(id);
    }

    public Doctor saveDoctor(Doctor doctor){
        //generate an id
        doctor.setId(ThreadLocalRandom.current().nextLong(0, 10000));
        this.doctors.put(doctor.getId(), doctor);
        return doctor;
    }

    public Doctor updateDoctor(Doctor doctor){
        this.doctors.put(doctor.getId(), doctor);
        return doctor;
    }

    public void deleteDoctor(Doctor doctor){
        this.doctors.remove(doctor.getId());
    }
    //patient

    public List<Patient> getPatients(){
        return new ArrayList<Patient>(patients.values());
    }

    public Patient getPatient(Long id){
        return patients.get(id);
    }

    public Patient savePatient(Patient patient){
        //generate an id
        patient.setId(ThreadLocalRandom.current().nextLong(0, 10000));
        this.patients.put(patient.getId(), patient);
        return patient;
    }

    public Patient updatePatient(Patient patient){
        this.patients.put(patient.getId(), patient);
        return patient;
    }

    public void deletePatient(Patient patient){
        this.patients.remove(patient.getId());
    }
}