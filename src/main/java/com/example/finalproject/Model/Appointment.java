package com.example.finalproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment {
       // المواعيد
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;

    @NotNull(message = "appointment Date is Required")
    private Date appointmentDate;

    @NotEmpty(message = "appointment Reason is Require")
    private String appointmentReason;

    @NotNull(message = "Appointment Completed : true or false ")
    private boolean isCompleted;

    @Pattern(regexp = "Scheduled|Cancelled|Completed" , message = "Status must be: Scheduled , Cancelled or Completed ")
    private String Status;

    @NotEmpty(message = "Appointment Type is Required ")
    private String appointmentType;


    // ----------------- Relations----------
//    @ManyToOne
//    @JsonIgnore
//    private Patient patient;


    @ManyToOne
    @JsonIgnore
    private Doctor doctor;// one doctor = many appointments


    @ManyToOne
    @JsonIgnore
    private MedicalHistory medicalHistory; // المواعيد داخل السجل الصحي للمريض

}
