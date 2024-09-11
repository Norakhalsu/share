package com.example.finalproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MedicalHistory {

    @Id
    private Integer id;

    @ElementCollection
    private List<String> pastIllnesses; // ماضي الأمراض
    @ElementCollection
    private List<String> pastSurgeries; // العمليات الجراحية الماضيه
    @ElementCollection
    private List<String> pastMedications;  // الادوية الماضية
    @ElementCollection
    private List<String> allergies; // حساسية
//    @ElementCollection
//    private List<String> familyMedicalHistory;
    @ElementCollection
    private List<String> healthHabits; // العادات الصحية


    // ----------------------- Relations

    @OneToOne
    @MapsId
    @JsonIgnore
    private Patient patient; //  one patient = one MedicalHistory


    @OneToMany(cascade = CascadeType.ALL)
    private List<Appointment> appointments; // لستتة المواعيد

    @ManyToMany
    private Set<Emergencies> emergencies; // عدة سجلات صحية تحتوي على عدة طلبات طارئة


}
