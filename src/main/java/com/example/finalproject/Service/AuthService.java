package com.example.finalproject.Service;

import com.example.finalproject.Model.User;
import com.example.finalproject.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;

    //ADMIN
    public List<User> getAllUser() {

        return authRepository.findAll();
    }

    //CUSTOMER - FARM -FARMER - COMPANY - SPECIALIST
    public void register(User user) {
        String hash = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hash);
        authRepository.save(user);

    }



//-------------------------------------   end CRUD  ---------------------------

}
