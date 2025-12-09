package com.example.springsecurity.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private String username ;
    private String password ;
//    private String email ;
//    private String temporatyPassword ;
//
//    @Column(name = "reset_password_token")
//    private String resetPasswordToken ;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private Collection<Role> roles = new ArrayList<>();

}
