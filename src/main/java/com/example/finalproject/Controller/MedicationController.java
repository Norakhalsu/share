package com.example.finalproject.Controller;

import com.example.finalproject.Api.ApiResponse;
import com.example.finalproject.Controller.InventoryItemController;
import com.example.finalproject.Model.Medication;
import com.example.finalproject.Model.User;
import com.example.finalproject.Service.MedicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/medication")
@RequiredArgsConstructor
public class MedicationController {

    private final MedicationService medicationService;

    Logger logger = LoggerFactory.getLogger(InventoryItemController.class);
//ALL
    @GetMapping("/get")
    public ResponseEntity getAllMedication(){
        logger.info("get all Medication");
        return ResponseEntity.ok(medicationService.getAllMedication());
    }
//ALL
    @PostMapping("/add")
    public ResponseEntity addMedication(@AuthenticationPrincipal User user, @RequestBody @Valid Medication medication){
        medicationService.addMedication(user.getId(), medication);
        logger.info("Medication added");
        return ResponseEntity.ok(new ApiResponse("Medication added"));
    }
//FARMER
    @PutMapping("/update")
    public ResponseEntity updateMedication(@AuthenticationPrincipal User user, @RequestBody @Valid Medication medication){
        medicationService.updateMedication(user.getId(), medication);
        logger.info("Medication updated");
        return ResponseEntity.ok(new ApiResponse("Medication updated"));
    }
//ADMIN
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMedication(@AuthenticationPrincipal User user, @PathVariable Integer id){
       medicationService.deleteMedication(id);
        logger.info("Medication deleted");
        return ResponseEntity.ok(new ApiResponse("Medication deleted"));
    }

    //-------------------------------------   end CRUD  ---------------------------

}
