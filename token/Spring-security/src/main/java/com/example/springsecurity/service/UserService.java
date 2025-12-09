package com.example.springsecurity.service;


import com.example.springsecurity.domain.Role;
import com.example.springsecurity.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User saveUser(User user);
    Role saveRole(Role  role);
    void addRoleToUser(String userName , String roleName) ;
    User getUser(String name ) ;
    List<User> getUsers() ;

    void updateResetPasswordToken(String token, String email, String pass);
//    User getByResetPasswordToken(String token) ;

    void updatePassword(User user, String newPassword);
}
