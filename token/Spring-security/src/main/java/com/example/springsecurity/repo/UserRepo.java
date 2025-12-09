package com.example.springsecurity.repo;


import com.example.springsecurity.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String name ) ;
//    User findByResetPasswordToken(String token) ;

//    User findByEmail(String email);
}
