package com.example.finalproject.Repository;


import com.example.project.Model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MedicationRepository extends JpaRepository<Medication,Integer> {
    Medication findMedicationById(Integer id);
}
