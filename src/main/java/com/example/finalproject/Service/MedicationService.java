package com.example.finalproject.Service;

import com.example.finalproject.Api.ApiException;
import com.example.finalproject.Model.Medication;
import com.example.finalproject.Repository.MedicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicationService {
    private final MedicationRepository medicationRepository;


    public List<Medication> getAllMedication() {
        return medicationRepository.findAll();
    }


    public void addMedication(Integer id,Medication medication){
        Medication medication1=medicationRepository.findMedicationById(id);
        if(medication1==null){
            throw new ApiException("not found");
        }

        medicationRepository.save(medication);
    }



    public void updateMedication(Integer id,Medication medication) {
        Medication medication1=medicationRepository.findMedicationById(id);
        if(medication1==null){
            throw new ApiException("not found");
        }
        medication1.setMedicalName(medication.getMedicalName());
        medication1.setMedicalType(medication.getMedicalType());
        medication1.setPrice(medication.getPrice());
        medication1.setDescription(medication.getDescription());
        medication1.setLicense(medication.isLicense());
        medication1.setQuantity(medication.getQuantity());
        medicationRepository.save(medication1);


    }

    public void deleteMedication(Integer id) {
        Medication medication1=medicationRepository.findMedicationById(id);
        if(medication1==null){
            throw new ApiException("not found");
        }
        medicationRepository.delete(medication1);
    }

    //---------------------------  end CRUD  ---------------------------------




}