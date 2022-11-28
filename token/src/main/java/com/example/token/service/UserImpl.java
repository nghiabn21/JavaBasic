package com.example.token.service;

import com.example.token.domain.Role;
import com.example.token.domain.User;
import com.example.token.exception.CustomerNotFoundException;
import com.example.token.repo.RoleRepo;
import com.example.token.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserImpl implements UserService{
    private final UserRepo userRepo ;

    private final RoleRepo roleRepo;

    @Override
    public User saveUser(User user) {
        log.info("Saving new user to the database");
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
           log.info("adding  role {} to user {} to the database", roleName, userName);
           User user = userRepo.findByUsername(userName) ;
           Role role = roleRepo.findByName(roleName) ;
           user.getRoles().add(role);
    }

    @Override
    public User getUser(String name) {
        log.info("Fetching username", name );
        return userRepo.findByUsername(name);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public void updateResetPasswordToken(String token, String email) throws CustomerNotFoundException {
        User user = userRepo.findByEmail(email);
        if (user != null) {
            user.setResetPasswordToken(token);
            userRepo.save(user);
        } else {
            throw new CustomerNotFoundException("Could not find any customer with the email " + email);
        }
    }

    public User getByResetPasswordToken(String token) {
        return userRepo.findByResetPasswordToken(token);
    }

    public void updatePassword(User user, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);

        user.setResetPasswordToken(null);
        userRepo.save(user);
    }


}
