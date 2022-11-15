package com.example.token.repo;

import com.example.token.domain.Role;
import com.example.token.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name ) ;
}