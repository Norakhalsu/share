package com.example.distantcare.Service;


import com.example.distantcare.Api.ApiException;
import com.example.distantcare.Model.Doctor;
import com.example.distantcare.Model.Hospital;
import com.example.distantcare.Model.Requests;
import com.example.distantcare.Repository.DoctorRepository;
import com.example.distantcare.Repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalService {
    private final HospitalRepository hospitalRepository;
    private final DoctorRepository doctorRepository;

    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    public void addHospitalToSystem(Hospital hospital) {
        hospitalRepository.save(hospital);
    }


    // ADMIN
    public void updateHospital(Integer hospitalId,Hospital hospital) {
        Hospital hospitalToUpdate = hospitalRepository.findHospitalByHospitalId(hospitalId);
        if (hospitalToUpdate == null) {
            throw new ApiException("Hospital not found");
        }
        hospitalToUpdate.setHospitalName(hospital.getHospitalName());
        hospitalToUpdate.setLocation(hospital.getLocation());
        hospitalRepository.save(hospital);
    }



    // ADMIN
    public void deleteHospital(Integer hospitalId) {
        Hospital hospital=hospitalRepository.findHospitalByHospitalId(hospitalId);
        if (hospital == null) {
            throw new ApiException("Hospital not found");
        }
        hospitalRepository.delete(hospital);
    }
   // -------------------------------- End point -----------------

    public int getPatientsCount(Integer hospitalId) {
        Hospital hospital = hospitalRepository.findHospitalByHospitalId(hospitalId);
        if (hospital == null) {
            throw new ApiException("Hospital not found");
        }
        if (hospital.getPatients().size() == 0) {
            throw new ApiException("No patients found");
        }
        return hospital.getPatients().size();
    }


    public void removeDoctorFromHospital(Integer hospitalId, Integer doctorId) {
        Hospital hospital = hospitalRepository.findHospitalByHospitalId(hospitalId);
        Doctor doctor = doctorRepository.findDoctorByDoctorId(doctorId);

        if (hospital == null) {
            throw new ApiException("Hospital not found");
        }
        if (doctor == null) {
            throw new ApiException("Doctor not found");
        }
        if (!hospital.getDoctors().contains(doctor)) {
            throw new ApiException("Doctor not found in Hospital");
        }

        hospital.getDoctors().remove(doctor);
        doctor.setHospitalName(null); // تعيين المستشفى الخاص بالطبيب إلى قيمة null
        doctorRepository.save(doctor); // حفظ التغييرات على الطبيب
    }


    public List<Requests> getRequestSetByHospital(Integer hospitalId) {
        Hospital hospital = hospitalRepository.findHospitalByHospitalId(hospitalId);
        if (hospital == null) {
            throw new ApiException("Hospital not found");
        }
        if (hospital.getRequestSet().size() == 0) {
            throw new ApiException("No set requests found");
        }

        return new ArrayList<>(hospital.getRequestSet());
         }


}
