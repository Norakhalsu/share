package com.example.finalproject.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Requests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer requestId ; // رقم الطلب

    private boolean requestStatus; // حالة الطلب




    // ----------------------- Relations ---------------
    @ManyToMany // عدة طلبات تكون في عدو سجلات طبية
    @JsonIgnore
    private Set<MedicalHistory> medHistory; // الطلب مربوط بالسجل بالطبي



}
