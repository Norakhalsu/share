package com.example.finalproject.Repository;

import com.example.finalproject.Model.Requests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Requests, Integer> {
    Requests findRequestByRequestId(Integer id);

}
