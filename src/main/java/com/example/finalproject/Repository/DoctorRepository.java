package com.example.finalproject.Repository;

import com.example.project.Model.BillingRecord;
import com.example.project.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    Doctor findDoctorById(Integer id);
}
