package com.example.finalproject.Repository;

import com.example.project.Model.BillingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingRecordRepository extends JpaRepository<BillingRecord,Integer> {
 //  BillingRecord findBillingRecordById(Integer id);
}
