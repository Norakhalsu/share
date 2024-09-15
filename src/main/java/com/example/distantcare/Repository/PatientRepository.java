package com.example.distantcare.Repository;

import com.example.distantcare.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Patient findPatientByPatientId(int id);
}
