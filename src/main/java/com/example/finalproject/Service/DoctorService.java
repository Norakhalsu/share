package com.example.finalproject.Service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import com.example.finalproject.Api.ApiException;
import com.example.finalproject.Model.Doctor;
import com.example.finalproject.Repository.DoctorRepository;
import com.example.finalproject.Api.ApiException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;



    public List<Doctor> getDoctor() {
        return doctorRepository.findAll();
    }

    public void addDoctor(Integer id,Doctor doctor) {
        Doctor doctor1 = doctorRepository.findDoctorById(id);
        if (doctor1 == null) {
            throw new ApiException("id not found");
        }
        doctorRepository.save(doctor);
    }

    public void updateDoctor(Integer id, Doctor doctor) {
        Doctor doctor1 = doctorRepository.findDoctorById(id);
        if (doctor1 == null) {
            throw new ApiException("id not found");
        }
       doctor1.setAppointments(doctor.getAppointments());
        doctor1.setDegree(doctor.getDegree());
        doctor1.setMajor(doctor.getMajor());
        doctorRepository.save(doctor1);
    }

    public void deleteDoctor(Integer id) {
        Doctor doctor1 = doctorRepository.findDoctorById(id);
        if (doctor1 == null) {
            throw new ApiException("id not found");
        }
        doctorRepository.delete(doctor1);
    }

    //---------------------------  end CRUD  ---------------------------------





}