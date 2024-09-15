package com.example.distantcare.Repository;

import com.example.distantcare.Model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository  extends JpaRepository<Hospital, Integer> {
    Hospital findHospitalByHospitalId(Integer hospitalId);
}
