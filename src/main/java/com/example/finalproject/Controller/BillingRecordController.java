package com.example.finalproject.Controller;

import com.example.finalproject.Api.ApiResponse;
import com.example.finalproject.Model.BillingRecord;
import com.example.finalproject.Model.User;
import com.example.finalproject.Service.BillingRecordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/billingRecord")
@RequiredArgsConstructor
public class BillingRecordController {

    private final BillingRecordService billingRecordService;

    Logger logger = LoggerFactory.getLogger(BillingRecordController.class);


//    @GetMapping("/get")
//    public ResponseEntity getAllBillingRecord(@AuthenticationPrincipal User user){
//        logger.info("get all BillingRecord");
//        return ResponseEntity.ok(billingRecordService.getAllBillingRecordCustomers());
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity addBillingRecord(@AuthenticationPrincipal User user,@RequestBody @Valid BillingRecord billingRecord){
//        billingRecordService.addBillingRecord(user.getId(), billingRecord);
//        logger.info("BillingRecord added");
//        return ResponseEntity.ok(new ApiResponse("BillingRecord created"));
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity updateBillingRecord(@AuthenticationPrincipal User user,@RequestBody @Valid BillingRecord billingRecord){
//        billingRecordService.updateBillingRecord(user.getId(),billingRecord );
//        logger.info("update BillingRecord");
//        return ResponseEntity.ok(new ApiResponse("BillingRecord updated"));
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity deleteBillingRecord(@PathVariable Integer id){
//       billingRecordService.deleteBillingRecord(id);
//        logger.info("BillingRecord deleted");
//        return ResponseEntity.ok(new ApiResponse("BillingRecord deleted"));
//    }


    //-------------------------------------   end CRUD  ---------------------------


}
