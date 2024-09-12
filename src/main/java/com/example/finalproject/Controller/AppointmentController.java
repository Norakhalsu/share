package com.example.finalproject.Controller;

import com.example.finalproject.Api.ApiResponse;
import com.example.finalproject.Model.*;
import com.example.finalproject.Service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    Logger logger = LoggerFactory.getLogger(AppointmentController.class);

//ADMIN
    @GetMapping("/get-all")
    public ResponseEntity getAllAppointment(@AuthenticationPrincipal User user){
        logger.info("get all Appointment");
        return ResponseEntity.ok(appointmentService.getAppointment());
    }
//ALL
    @PostMapping("/add")
    public ResponseEntity addAppointment(@AuthenticationPrincipal User user,@RequestBody @Valid Appointment appointment){
        appointmentService.addAppointment(user.getId(), appointment);
        logger.info("Appointment added");
        return ResponseEntity.ok(new ApiResponse("Appointment created"));
    }
//COMPANY
    @PutMapping("/update")
    public ResponseEntity updateAppointment(@AuthenticationPrincipal User user, @RequestBody @Valid Appointment appointment){
        appointmentService.updateAppointment(user.getId(), appointment);
        logger.info("update Appointment");
        return ResponseEntity.ok(new ApiResponse("Appointment updated"));
    }
    //ADMIN
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAppointment(@PathVariable Integer id){
        appointmentService.deleteAppointment(id);
        logger.info("Appointment deleted");
        return ResponseEntity.ok(new ApiResponse("Appointment deleted"));
    }
    //-------------------------------------   end CRUD  ---------------------------



}
