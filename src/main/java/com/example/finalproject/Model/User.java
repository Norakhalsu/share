package com.example.finalproject.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Username Require")
    @Size(min = 4,max = 15 , message = "Username length must be 4-15 characters ")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Username must contain only letters and numbers")
    @Column(columnDefinition = "varchar(15) UNIQUE NOT NULL ")
    private String username;

    @NotEmpty(message = "Password Required")
    @Size(min = 6 , max = 15 , message = "Password length must be 6-15 characters ")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", message = "Password must contain symbols, numbers, and uppercase and lowercase characters")
    @Column(columnDefinition = "varchar(15) UNIQUE NOT NULL ")
    private String password;

    @NotEmpty(message = "Full name is Required")
    @Size(min = 3, max = 35 , message = "Full name length must be between 3-35 characters ")
    @Column(columnDefinition = "varchar(35) UNIQUE NOT NULL ")
    private String fullName;

    @NotNull(message = "Birthday Date is Required")
   // @Column(columnDefinition = "date NOT NULL ")
    private LocalDate birthDate;

    @NotEmpty(message = "Phone Number is Required ")
    @Pattern(regexp="\\d+", message="Phone number must contain only integers")
    @Size(max = 10 , message = "PhoneNumber must be 10 characters ")
    @Column(columnDefinition = "varchar(10) UNIQUE NOT NULL ")
    private String phoneNumber;

    @NotEmpty(message = "Emergency Phone Number is Required ")
    @Pattern(regexp="\\d+", message="Emergency Phone number must contain only integers")
    @Size(max = 10 , message = "PhoneNumber must be 10 characters ")
    @Column(columnDefinition = "varchar(10) UNIQUE NOT NULL ")
    private String emergencyPhoneNumber;

    @NotNull(message = "Age is Required")
    @Column(columnDefinition = "int NOT NULL ")
    private int age;

    @Email(message = "Email must be valid format ")
    @Size(max = 30 , message = "Email length max 30 characters ")
    @Column(columnDefinition = "varchar(30) UNIQUE NOT NULL ")
    private String email;

    @NotEmpty(message = "gender is Required")
    @Pattern(regexp = "^(male|female)$", message = "Gender must be either Male or Female")
   //@Column(columnDefinition = "varchar(6) NOT NULL CHECK(gender=male or gender=female) ")
    private String gender;

    @NotEmpty(message = "Address is Required")
    @Column(columnDefinition = "varchar(30) NOT NULL ")
    private String address;


    // ------------------ Relations -----------

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "user")
    @PrimaryKeyJoinColumn
    private Set<Patient> patient;



}
