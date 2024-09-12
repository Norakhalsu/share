package com.example.finalproject.Service;

import com.example.project.Api.ApiException;

import com.example.finalproject.Repository.MedicalHistoryRepository;
import com.example.finalproject.Model.MedicalHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalHistoryService {

    private final MedicalHistoryRepository medicalHistoryRepository;


    public List<MedicalHistory> getAllMedicalHistory(){
        return medicalHistoryRepository.findAll();
    }

    public void addMedicalHistory(Integer id,MedicalHistory medicalHistory){
        MedicalHistory medicalHistory1 =medicalHistoryRepository.findMedicalHistoryById(id);
        if(medicalHistory1==null){
            throw new ApiException("owner not found");
        }

        medicalHistoryRepository.save(medicalHistory);
    }

    public void updateMedicalHistory(Integer id,MedicalHistory medicalHistory){
        MedicalHistory medicalHistory1 =medicalHistoryRepository.findMedicalHistoryById(id);
        if(medicalHistory1==null){
            throw new ApiException("owner not found");
        }

        medicalHistory1.setAllergies(medicalHistory.getAllergies());
        medicalHistory1.setHealthHabits(medicalHistory.getHealthHabits());
        medicalHistory1.setPastIllnesses(medicalHistory.getPastIllnesses());
        medicalHistory1.setPastMedications(medicalHistory.getPastMedications());
        medicalHistory1.setPastSurgeries(medicalHistory.getPastSurgeries());

        medicalHistoryRepository.save(medicalHistory);
    }

    public void deleteMedicalHistory(Integer id){
        MedicalHistory medicalHistory1 =medicalHistoryRepository.findMedicalHistoryById(id);
        if(medicalHistory1==null){
            throw new ApiException("owner not found");
        }

        medicalHistoryRepository.delete(medicalHistory1);
    }

    //---------------------------  end CRUD  ---------------------------------




}