package com.fiipractic.health.mapper;

import com.fiipractic.health.model.Doctor;
import com.fiipractic.health.model.Patient;

public class ObjectMapper {

    public static void map2DoctorDb(Doctor doctorDb, Doctor doctorRequest){
        doctorDb.setName(doctorRequest.getName());
        doctorDb.setFunction(doctorRequest.getFunction());
    }

    public static void map2PatientDb(Patient patientDb, Patient patientRequest)
    {
        patientDb.setName(patientRequest.getName());
        patientDb.setAge(patientRequest.getAge());
        patientDb.setMalady(patientRequest.getMalady());
        patientDb.setMedicalTreatment(patientRequest.getMedicalTreatment());
    }
}
