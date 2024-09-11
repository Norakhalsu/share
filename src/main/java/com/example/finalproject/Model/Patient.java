package com.example.finalproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {

    @Id
    private Integer id ;

    @NotEmpty(message = "Health Status is Required")
    private String HealthStatus; // الحالة الصحية


    // ----------------------------------------- Relations ----------------
    @ManyToOne
    @MapsId
    @JsonIgnore
    private User user;


    @OneToOne(cascade = CascadeType.ALL , mappedBy = "patient") // السجل الطبي للمريض
    @PrimaryKeyJoinColumn
    private MedicalHistory medicalHistory ;






}
