package com.example.finalproject.Controller;

import com.example.finalproject.Api.ApiResponse;
import com.example.finalproject.Controller.BillingRecordController;
import com.example.finalproject.Model.Doctor;
import com.example.finalproject.Model.User;
import com.example.finalproject.Service.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;
    Logger logger = LoggerFactory.getLogger(BillingRecordController.class);


    //ADMIN
    @GetMapping("/get")
    public ResponseEntity getAllDoctor(@AuthenticationPrincipal User user) {
        logger.info("get all Doctor");
        return ResponseEntity.ok(doctorService.getDoctor());
    }

    //ALL
    @PostMapping("/add")
    public ResponseEntity addDoctor(@AuthenticationPrincipal User user, @RequestBody @Valid Doctor doctor) {
        doctorService.addDoctor(user.getId(), doctor);
        logger.info("Doctor added");
        return ResponseEntity.ok(new ApiResponse("Doctor created"));
    }

    //COMPANY
    @PutMapping("/update")
    public ResponseEntity updateDoctor(@AuthenticationPrincipal User user, @RequestBody @Valid Doctor doctor) {
        doctorService.updateDoctor(user.getId(), doctor);
        logger.info("update Doctor");
        return ResponseEntity.ok(new ApiResponse("Doctor updated"));
    }

    //ADMIN
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDoctor(@PathVariable Integer id) {
        doctorService.deleteDoctor(id);
        logger.info("Doctor deleted");
        return ResponseEntity.ok(new ApiResponse("Doctor deleted"));
    }
}