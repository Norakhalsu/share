package com.example.finalproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.crypto.Mac;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BillingRecord {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private LocalDateTime billingDate = LocalDateTime.now(); // تاريخ دفع الفاتوره

    @NotNull(message = "Cost is Required")
    private double cost; // مبلغ الفاتورة
    @NotEmpty(message = "Status is required")
    private String Status; // حالة الفاتورة : مدفوعة او غير مدفوعة


    // ------------------------- Relations --------

    @ManyToMany
    @JsonIgnore
    private Set<MedicalHistory> medicalHistory;
}
