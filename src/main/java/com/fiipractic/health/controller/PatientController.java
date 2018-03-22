package com.fiipractic.health.controller;

import com.fiipractic.health.exceptions.BadRequestException;
import com.fiipractic.health.exceptions.NotFoundException;
import com.fiipractic.health.mapper.ObjectMapper;
import com.fiipractic.health.model.Doctor;
import com.fiipractic.health.model.Patient;
import com.fiipractic.health.service.DoctorService;
import com.fiipractic.health.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="patients")
public class PatientController {

    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getPatients(){
        return patientService.getPatients();
    }

    @GetMapping(value = "/{id}")
    public Patient getPatient(@PathVariable("id") Long id) throws NotFoundException {
        Patient patient = patientService.getPatient(id);
        if(patient == null){
            throw new NotFoundException(String.format("Patient with id=%s was not found.", id));
        }
        return patient;
    }

    @PutMapping(value = "/{id}")
    public Patient updatePatient(@PathVariable("id") Long id, @RequestBody Patient patient) throws BadRequestException, NotFoundException {
        //validate request
        if(!id.equals(patient.getId())){
            throw new BadRequestException("The id is not the same with id from object");
        }
        Patient patientDb = patientService.getPatient(id);
        if(patientDb == null){
            throw new NotFoundException(String.format("Paient with id=%s was not found.", id));
        }
        ObjectMapper.map2PatientDb(patientDb, patient);
        return patientService.updatePatient(patientDb);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Patient savePatient(@RequestBody Patient patient){
        return patientService.savePatient(patient);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletePatient(@PathVariable Long id) throws NotFoundException {
        Patient patientDb = patientService.getPatient(id);
        if(patientDb == null){
            throw new NotFoundException(String.format("Patient with id=%s was not found.", id));
        }
        patientService.deletePatient(patientDb);
    }
}