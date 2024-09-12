package com.example.finalproject.Service;

import com.example.finalproject.Api.ApiException;
import com.example.finalproject.Model.BillingRecord;
//import com.example.finalproject.Repository.BillingRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BillingRecordService {

  //  private final BillingRecordRepository billingRecordRepository;


//    public List<BillingRecord> getAllBillingRecordCustomers() {
//
//        return billingRecordRepository.findAll();
//    }
//
//
//
//    public void addBillingRecord(Integer id,BillingRecord billingRecord) {
//        BillingRecord billingRecord1 =billingRecordRepository.findBillingRecordById(id);
//
//        if (billingRecord1 == null) {
//            throw new ApiException("id not found");
//        }
//        billingRecordRepository.save(billingRecord);
//    }
//
//
//
//    public void updateBillingRecord(Integer id,BillingRecord billingRecord) {
//        BillingRecord billingRecord1 =billingRecordRepository.findBillingRecordById(id);
//
//        if (billingRecord1 == null) {
//            throw new ApiException("id not found");
//        }
//
//
//        billingRecordRepository.save(billingRecord1);
//
//    }
//
//    public void deleteBillingRecord(Integer id) {
//        BillingRecord  billingRecord1 =billingRecordRepository.findBillingRecordById(id);
//        if (billingRecord1 == null) {
//            throw new ApiException("id not found");
//        }
//        billingRecordRepository.delete(billingRecord1);
//    }


    //---------------------------  end CRUD  ---------------------------------

}


