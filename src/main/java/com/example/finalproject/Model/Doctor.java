package com.example.finalproject.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Doctor {

    @Id
    private Integer id;

    @NotEmpty(message = "Doctor Major must be not empty")
    private String major; // تخصص الطبيب

    @NotEmpty(message = "Degree is required")
    private String degree; // الدرجة العلمية

    // ----------------------- Relations --------

    @ManyToOne
    @JsonIgnore
    private User user; //


    @OneToMany
    private Set<Appointment> appointments; // الدكتور الواحد يعطي مجموعه مواعيد

}
