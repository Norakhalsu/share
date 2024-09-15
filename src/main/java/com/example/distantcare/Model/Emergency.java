package com.example.distantcare.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Emergency {
    // نوع من انواع الصداع الحاد يلازم المريض لمدة 72 ساعه مع الم حاد ولا يبي يشوف ولا يبي يسمع اشيا

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "status Patient is Required ")
    private String statusPatient; //الحالة الشقيقه statusmignorosus

    @NotNull(message = "Hours Cases must be not null")
    @Min(0)
    @Max(48)
    private int hoursCase;// خلال فترة زمنيه معقوله
    @NotEmpty(message = "Medication is Required")
    private String medicationName;
    @NotEmpty(message =" Doses is Required" )
    private String doses; //جرعات


    // --------------- Relations ------------
      @OneToOne
      @JsonIgnore
       private Requests request;




//    @ManyToMany
//    private Set<HealthRecord> healthRecordSet;
}
