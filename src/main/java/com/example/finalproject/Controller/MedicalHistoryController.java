package com.example.finalproject.Controller;

import com.example.finalproject.Api.ApiResponse;
import com.example.finalproject.Controller.PatientController;
import com.example.finalproject.Model.MedicalHistory;
import com.example.finalproject.Model.User;
import com.example.finalproject.Service.MedicalHistoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order-plant")
@RequiredArgsConstructor
public class MedicalHistoryController {
    private final MedicalHistoryService medicalHistoryService;
    Logger logger = LoggerFactory.getLogger(PatientController.class);

//ADMIN
    @GetMapping("/get")
    public ResponseEntity getMedicalHistory(){
        logger.info("get MedicalHistory");
        return ResponseEntity.ok(medicalHistoryService.getAllMedicalHistory());
    }

        //COMPANY - CUSTOMER  //Sara
    @PostMapping("/add")
    public ResponseEntity addMedicalHistory(@AuthenticationPrincipal User user, @RequestBody @Valid MedicalHistory medicalHistory){
        logger.info("add MedicalHistory");
        medicalHistoryService.addMedicalHistory(user.getId(), medicalHistory);
        return ResponseEntity.ok(new ApiResponse("add MedicalHistory successfully"));
    }

    @PutMapping("/update")
    public ResponseEntity updateMedicalHistory(@AuthenticationPrincipal User user, @RequestBody @Valid MedicalHistory medicalHistory){
        logger.info("update MedicalHistory");
        medicalHistoryService.updateMedicalHistory(user.getId(), medicalHistory);
        return ResponseEntity.status(200).body(new ApiResponse("update  MedicalHistory Successful"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMedicalHistory( @PathVariable Integer id){
       medicalHistoryService.deleteMedicalHistory(id);
        logger.info("InventoryItem deleted");
        return ResponseEntity.ok(new ApiResponse("InventoryItem deleted"));
    }

    //-------------------------------------   end CRUD  ---------------------------

}
