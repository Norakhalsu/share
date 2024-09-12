package com.example.finalproject.Controller;

import com.example.finalproject.Api.ApiResponse;
import com.example.finalproject.Model.Patient;
import com.example.finalproject.Model.User;
import com.example.finalproject.Service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService PatientService;
    Logger logger = LoggerFactory.getLogger(PatientController.class);

//ADMIN
    @GetMapping("/get")
    public ResponseEntity getPatient(){
        logger.info("get Patient");
        return ResponseEntity.ok(PatientService.getAllPatient());
    }

    @PostMapping("/add")
    public ResponseEntity addPatient(@AuthenticationPrincipal User user,@RequestBody @Valid Patient patient){
        PatientService.addPatient(user.getId(), patient);
        logger.info("Patient added");
        return ResponseEntity.ok(new ApiResponse("Patient added successfully"));
    }

    @PutMapping("/update")
    public ResponseEntity updatePatient(@AuthenticationPrincipal User user, @RequestBody @Valid Patient patient){
        logger.info("update Patient");
        PatientService.updatePatient(user.getId(), patient);
        return ResponseEntity.status(200).body(new ApiResponse("update Patient"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePatient(@AuthenticationPrincipal User user, @PathVariable Integer id){
        PatientService.deletePatient(user.getId());
        logger.info("Patient deleted");
        return ResponseEntity.ok(new ApiResponse("Patient deleted"));
    }


    //-------------------------------------   end CRUD  ---------------------------


}
