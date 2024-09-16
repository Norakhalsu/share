package com.example.distantcare.Service;


import com.example.distantcare.Api.ApiException;
import com.example.distantcare.Model.*;
import com.example.distantcare.Repository.HospitalRepository;
import com.example.distantcare.Repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.aop.AopInvocationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestRepository requestRepository;
    private final HospitalRepository hospitalRepository;


    public void newRequest(Integer hospitalId, Integer patientId, Requests request) {
        Hospital hospital = hospitalRepository.findHospitalByHospitalId(hospitalId);
        if (hospital == null) {
            throw new ApiException("Hospital Not Found");
        }

        hospital.getPatients().stream()
                .filter(p -> p.getPatientId().equals(patientId))
                .findFirst()
                .orElseThrow(() -> new ApiException("Patient Not Found"));

        request.setHospital(hospital);

        if (request.getType().equalsIgnoreCase("Emergency")) {
            Emergency emergency = new Emergency();
            emergency.setStatusPatient(request.getEmergency().getStatusPatient());
            emergency.setHoursCase(request.getEmergency().getHoursCase());
            emergency.setMedicationName(request.getEmergency().getMedicationName());
            emergency.setDoses(request.getEmergency().getDoses());
            request.setEmergencyRequest(true); // true
            request.setUrgentRequest(false);

            if (request.getHotLine() != null) {
                request.getHotLine().getRequestSet().add(request);
            }
            hospital.getRequestSet().add(request);
        }


        else if (request.getType().equalsIgnoreCase("Urgent")) {
            Urgent urgent = new Urgent();
            urgent.setStatusPatient(request.getUrgent().getStatusPatient());

            if(urgent.getKnownOnset()!= null){
            urgent.setHoursCase(request.getUrgent().getHoursCase());
            urgent.setMedicationName(request.getUrgent().getMedicationName());
            urgent.setDoses(request.getUrgent().getDoses());
            urgent.setRequest(request);
            request.setUrgentRequest(true);// true
            request.setEmergencyRequest(false);
        }

      else if (urgent.getUnKnownOnset().equalsIgnoreCase("core" )|| urgent.getUnKnownOnset().equalsIgnoreCase("pinmra")) {
         urgent.setHoursCase(request.getUrgent().getHoursCase());
         urgent.setMedicationName(request.getUrgent().getMedicationName());
         urgent.setDoses(request.getUrgent().getDoses());
         urgent.setRequest(request);
         request.setUrgentRequest(true);
      }
        }
            requestRepository.save(request);
    }



//    public void newRequest(Integer hospitalId, Integer patientId, Requests request) {
//        Hospital hospital = hospitalRepository.findHospitalByHospitalId(hospitalId);
//        if (hospital == null) {
//            throw new ApiException("Hospital Not Found");
//        }
//
//        Patient patient = hospital.getPatients().stream()
//        .filter(p -> p.getPatientId().equals(patientId)).findFirst().orElse(null);
//        if (patient == null) {
//            throw new ApiException("Patient Not Found");
//        }
//
//        request.setHospital(hospital);
//
//        if (request.getType().equalsIgnoreCase("Emergency")) {
//            Emergency emergency = new Emergency();
//            emergency.setStatusPatient("Severe Headache صداع الشقيقة");
//            emergency.setHoursCase(72);
//            emergency.setMedicationName("Painkillers");
//            emergency.setDoses("As needed");
//            emergency.setRequest(request);
//
//            request.setEmergencyRequest(true);
//
//            if (request.getHotLine() != null) {
//                request.getHotLine().getRequestSet().add(request);
//            }
//
//            hospital.getRequestSet().add(request);
//        } else if (request.getType().equalsIgnoreCase("Urgent")) {
//              Urgent urgent = new Urgent();
//              urgent.setStatusPatient("stroke السكتة الدماغية");
//              urgent.setHoursCase(3);
//              urgent.setMedicationName("Painkillers");
//              urgent.setDoses("As needed");
//              urgent.setRequest(request);
//        }
//        requestRepository.save(request);
//    }



    public Patient getPatientById(Integer patientId) {
        HealthRecord healthRecord = new HealthRecord();
        Patient patient = healthRecord.getPatient(); // تأكد من أن الطريقة تعيد المريض بناءً على المعرف

        if (patient != null) {
            if (patient.getPatientId().equals(patientId)) {
                return patient;
            } else {
                throw new ApiException("Patient Not Found");
            }
        } else {
            throw new ApiException("Patient Not Found");
        }
    }



        // Hospital
    public List<Requests> getAllRequests() {
        return requestRepository.findAll();
    }


    // HOSPITAL - HOTLINE
    public void updateRequest(Integer hospitalId,Integer requestId, Requests request) {
        Hospital hospital=hospitalRepository.findHospitalByHospitalId(hospitalId);
        if (hospital == null) {
            throw new ApiException("Hospital Not Found");
        }
        Requests requests=requestRepository.findRequestByRequestId(requestId);
        if (requests == null) {
            throw new ApiException("Request Not Found");
        }
        if (request.getType().equalsIgnoreCase("emergency")) {
            request.setEmergency(request.getEmergency());
            request.setHotLine(request.getHotLine());
            requestRepository.save(request);
        }
    }


    public void deleteRequest(Integer hospitalId,Integer requestId) {
        Hospital hospital=hospitalRepository.findHospitalByHospitalId(hospitalId);
        if (hospital == null) {
            throw new ApiException("Hospital Not Found");
        }
        Requests request=requestRepository.findRequestByRequestId(requestId);
        if (request == null) {
            throw new ApiException("Request Not Found");
        }
        requestRepository.delete(request);
    }


    // --------------------------- end point ------------------------

    public void statusAcceptRequest(int requestId) {
        Requests request = requestRepository.findRequestByRequestId(requestId);

        if (request == null) {
            throw new ApiException("Request Not Found");
        }

        String currentStatus = request.getStatus();
        switch (currentStatus.toLowerCase()) {
            case "accept":
                throw new ApiException("Request already accepted");
            case "canceled":
                throw new ApiException("Request was canceled");
            case "completed":
                throw new ApiException("Request was completed");
            case "pending":
                request.setStatus("Accepted"); // يمكن تعديل هذا حسب هيكل الطلب الخاص بك
                requestRepository.save(request);
                break;
            default:
                throw new ApiException("Invalid request status");
        }
    }



    public int calculateTotalHoursRequired(int requestId) {
        Requests request = requestRepository.findRequestByRequestId(requestId);

        if (request == null) {
            throw new ApiException("Request Not Found");
        }

        int totalHoursRequired = request.getHoursRequired();
        if (totalHoursRequired == 0) {
            throw new ApiException("Request: Hours equal zero");
        } else if (totalHoursRequired >= 2 && totalHoursRequired <= 6) {
            return totalHoursRequired;
        } else {
            throw new ApiException("Hours Required Not within Range");
        }
    }




    public String requestPriority(int requestId) {
        Requests request = requestRepository.findRequestByRequestId(requestId);

        if (request == null) {
            throw new ApiException("Request Not Found");
        }
        int hoursRequired = request.getHoursRequired();
        if (hoursRequired < 7) {
            return "هام جدًا";
        } else if (hoursRequired > 8 && hoursRequired < 20) {
            return "عاجل";
        } else {
            return "عادي";
        }




    }





}
