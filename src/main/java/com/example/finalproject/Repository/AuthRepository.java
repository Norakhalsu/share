package com.example.finalproject.Repository;

import com.example.project.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<User,Integer> {
    User findUserByUsername(String username);
    User findUserById(Integer id);


}
