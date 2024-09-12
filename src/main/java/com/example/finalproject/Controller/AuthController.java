package com.example.finalproject.Controller;

import com.example.finalproject.Api.ApiException;
import com.example.finalproject.Api.ApiResponse;
import com.example.finalproject.Model.User;
import com.example.finalproject.Service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    Logger logger = LoggerFactory.getLogger(AuthController.class);

    //ADMIN
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser(){
        logger.info("all user requested");
        return ResponseEntity.ok(authService.getAllUser());
    }
     //ALL
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid User user){
        authService.register(user);
        logger.info("guest register");
        return ResponseEntity.ok(new ApiResponse("user added"));
    }

    @PostMapping("/login")
    public ResponseEntity login(){

        return ResponseEntity.ok().body(new ApiException("welcome"));
    }

    @PostMapping("/logout")
    public ResponseEntity logOut(){
        return ResponseEntity.ok().body(new ApiResponse("goodbye"));
    }


}
