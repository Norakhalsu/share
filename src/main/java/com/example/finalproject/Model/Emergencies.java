package com.example.finalproject.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Emergencies {

    //  طلبات الحالات الطارئه المقدمة


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    // ---------------------------- Relations ------------
    @ManyToMany
    private Set<MedicalHistory>medicalHistory; //
}
