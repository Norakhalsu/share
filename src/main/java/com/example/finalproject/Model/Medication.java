package com.example.finalproject.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Medication {
                      // الادوية
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Medical Name us Required ")
    private String medicalName;

    @NotEmpty(message = "Medical Name us Required ")
    private String description;

    @NotEmpty(message = "Medical Name us Required ")
    private String medicalType;

    @NotNull(message = "price is Required")
    private int price;

    @NotNull(message = "Quantity is Required")
    private int quantity;

    private boolean license=true;


    private String medicationDoses; // جرعات الدواء

}
