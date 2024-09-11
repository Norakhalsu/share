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

    @NotEmpty(message = "Full name is Required")
    @Size(min = 3, max = 30 , message = "Full name length must be between 3-30 characters ")
    private String fullName;

    @NotNull(message = "Birthday Date is Required")
    private LocalDate birthDate;

    @NotEmpty(message = "Phone Number is Required ")
    @Pattern(regexp="\\d+", message="Phone number must contain only integers")
    private String phoneNumber;

    @NotNull(message = "Age is Required")
    private int age;

    @Email(message = "Email must be valid format ")
    private String email;

    @NotEmpty(message = "gender is Required")
    @Pattern(regexp = "^(Male|Female)$", message = "Gender must be either Male or Female")
    private String gender;

    @NotEmpty(message = "Address is Required")
    private String address;


    // --------------------------- Relations -----------

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "user")
    @PrimaryKeyJoinColumn
    private Set<Patient> patient;
}
