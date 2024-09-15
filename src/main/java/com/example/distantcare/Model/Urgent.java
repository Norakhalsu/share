package com.example.distantcare.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Urgent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer urgentId;

    @NotEmpty(message = "status Patient is Required")
    private String statusPatient; // stroke السكتة الدماغية

    @NotNull(message = "Hours Cases must be not null , must between 2-6 hours ")
    @Min(2)
    @Max(6)
    private int hoursCase;

    @NotEmpty(message = "Medication is Required")
    private String medicationName;

    @NotEmpty(message =" Doses is Required" )
    private String doses; //جرعات

   // @NotEmpty(message = "UnKnown Onset is Required")
    @Pattern(regexp = "^(core|pinmra)$", message = "Onset must be either core , pinmra ")
    private String unKnownOnset; //core =deaid area ,, pinmra = area can be saved --  using bitskan

    private String KnownOnset;


    // ---------------- Relations ----------
    @OneToOne
    @JsonIgnore
    private Requests request;


}
