package com.example.finalproject.Service;

import com.example.finalproject.Api.ApiException;
import com.example.finalproject.Model.Emergencies;
import com.example.finalproject.Repository.EmergenciesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmergenciesService {

    private final EmergenciesRepository emergenciesRepository;


    public List<Emergencies> getAllEmergencies(){
        return emergenciesRepository.findAll();
    }

    public void addEmergencies(Integer id , Emergencies emergencies){
        Emergencies emergencies1 =emergenciesRepository.findEmergenciesById(id);
        if(emergencies1==null){
            throw new ApiException("id not found");
        }

        emergenciesRepository.save(emergencies);
    }


    public void updateEmergencies(Integer id,Emergencies emergencies){
        Emergencies emergencies1 =emergenciesRepository.findEmergenciesById(id);
        if(emergencies1==null){
            throw new ApiException("id not found");
        }
emergencies1.setMedicalHistory(emergencies.getMedicalHistory());

        emergenciesRepository.save(emergencies1);
    }

    public void deleteEmergencies(Integer id){
        Emergencies emergencies1 =emergenciesRepository.findEmergenciesById(id);
        if(emergencies1==null){
            throw new ApiException("id not found");
        }
        emergenciesRepository.delete(emergencies1);
    }

    //---------------------------  end CRUD  ---------------------------------

}