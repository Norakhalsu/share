package com.example.finalproject.Service;

import com.example.finalproject.Api.ApiException;
import com.example.finalproject.Model.Patient;
import com.example.finalproject.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;


    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }


    public void addPatient(Integer id,Patient patient){
        Patient patient1 =patientRepository.findPatientById(id);
        if(patient1==null){
            throw new ApiException("not found");
        }

        patientRepository.save(patient);
    }



    public void updatePatient(Integer id,Patient patient) {
        Patient patient1 =patientRepository.findPatientById(id);
        if(patient1==null){
            throw new ApiException("not found");
        }
        patient1.setHealthStatus(patient.getHealthStatus());
        patient1.setMedicalHistory(patient.getMedicalHistory());

        patientRepository.save(patient1);
    }


    public void deletePatient(Integer id) {
        Patient patient1 =patientRepository.findPatientById(id);
        if(patient1==null){
            throw new ApiException("not found");
        }

        patientRepository.delete(patient1);
    }

    //---------------------------  end CRUD  ---------------------------------



}