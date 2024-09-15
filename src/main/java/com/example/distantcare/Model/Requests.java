package com.example.distantcare.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Requests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer requestId;

    @NotEmpty(message = "Type Request is Required")
    @Pattern(regexp = "^(Emergency|Urgent)$", message = "Type Request must be Emergency or Urgent")
    private String type;

    private boolean facility;
    private String tools;
    private String accept;
    private boolean emergencyRequest;
    private boolean urgentRequest;
    private int hoursRequired;

    // ------------- Relations ----------
    @OneToOne(cascade = CascadeType.ALL)
    private Emergency emergency;

    @OneToOne(cascade = CascadeType.ALL)
    private Urgent urgent;

    @ManyToOne
    private HotLine hotLine;

    @ManyToOne
    private Hospital hospital; // الطلبات تنرفع من المستشفيات وتوصل للهوت لاين
}
