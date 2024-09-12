package com.example.finalproject.Service;

import com.example.finalproject.Model.MedicalHistory;
import com.example.finalproject.Model.Patient;
import com.example.finalproject.Model.Requests;
import com.example.finalproject.Model.User;
import com.example.finalproject.Repository.MedicalHistoryRepository;
import com.example.finalproject.Repository.RequestRepository;
import com.example.finalproject.Repository.UserRepository;
import com.example.project.Api.ApiException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class RequestService {
    private RequestRepository requestRepository;
    private UserRepository userRepository;
    private MedicalHistoryRepository medicalHistoryRepository;

    public List<Requests> getAllRequests() {
       return requestRepository.findAll();
    }


    public Requests getRequestById(int id) {
        Requests requests=requestRepository.findRequestByRequestId(id);
        if (requests==null){
            throw new ApiException("Request not found");
        }
        return requests;
    }


    public void addRequest(Integer userId, Integer medicalRecordId, Requests request) {
        User user = userRepository.findUserById(userId);
        if (user == null) {
            throw new ApiException("Unauthorized!");
        }
        MedicalHistory medicalRecord = medicalHistoryRepository.findMedicalHistoryBy(medicalRecordId);
        if (medicalRecord == null) {
            throw new ApiException("Medical Record not found!");
        }
        // ربط السجل الصحي بالمستخدم
        Patient patient=new Patient();
        patient.setMedicalHistory(medicalRecord);
        // ربط السجل الصحي بالطلب
        medicalRecord.setRequests((Set<Requests>) request);
        userRepository.save(user);
        requestRepository.save(request);
    }



    public void deleteRequest(Integer userId , Integer requestId) {
        User user = userRepository.findUserById(userId);
        Requests request = requestRepository.findRequestByRequestId(requestId);
        if (user == null) {
            throw new ApiException("Unauthorized to delete request !! ");
        }
        if (request == null) {
            throw new ApiException("Request not found! ");
        }
        requestRepository.delete(request);
    }

    public void updateRequest(Integer userId , Integer requestId , Requests request) {
        User user = userRepository.findUserById(userId);
        Requests request1 = requestRepository.findRequestByRequestId(requestId);
        if (user == null) {
            throw new ApiException("Unauthorized to update request !! ");
        }
        if (request1 == null) {
            throw new ApiException("Request not found! ");
        }
          // request1.setName(request.getName())
         // request1.setRequestType(request.setRequestType())
        // request1

    }

}
