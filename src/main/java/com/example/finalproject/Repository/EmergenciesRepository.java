package com.example.finalproject.Repository;

import com.example.project.Model.Emergencies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergenciesRepository extends JpaRepository<Emergencies,Integer> {
    Emergencies findEmergenciesById(Integer id);
}
