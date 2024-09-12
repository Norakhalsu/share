package com.example.finalproject.Controller;

import com.example.finalproject.Api.ApiResponse;
import com.example.finalproject.Model.*;
import com.example.finalproject.Service.EmergenciesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/emergencies")
@RequiredArgsConstructor
public class EmergenciesController {

    private final EmergenciesService emergenciesService;
  Logger logger = LoggerFactory.getLogger(EmergenciesController.class);

//ADMIN
    @GetMapping("/get")
    public ResponseEntity getAllEmergencies(){
        logger.info("get all Emergencies");
        return ResponseEntity.ok(emergenciesService.getAllEmergencies());
    }

//ALL
    @PostMapping("/add")
    public ResponseEntity addEmergencies(@AuthenticationPrincipal User user,@RequestBody @Valid Emergencies emergencies){
        emergenciesService.addEmergencies(user.getId(), emergencies);
        return ResponseEntity.ok(new ApiResponse("Emergencies registered"));
    }

//CUSTOMER
    @PutMapping("/update")
    public ResponseEntity updateEmergencies(@AuthenticationPrincipal User user, @RequestBody @Valid Emergencies emergencies){
        emergenciesService.updateEmergencies(user.getId(), emergencies);
        logger.info("Emergencies updated");
        return ResponseEntity.ok(new ApiResponse("Emergencies update"));
    }
//ADMIN
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteEmergencies(@PathVariable Integer id){
        emergenciesService.deleteEmergencies(id);
        logger.info("Emergencies deleted");
        return ResponseEntity.ok(new ApiResponse("Emergencies deleted"));
    }
//-------------------------------------   end CRUD  ---------------------------



}
