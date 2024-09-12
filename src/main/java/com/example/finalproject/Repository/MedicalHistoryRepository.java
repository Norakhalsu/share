package com.example.finalproject.Repository;


import com.example.finalproject.Model.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Integer> {
   // MedicalHistory findMedicalHistoryBy(Integer id);
}
