package com.sample.smartevents.domain;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @NonNull
    @Column(name = "fname")
    private String firstName;

    @NonNull
    @Column(name = "lname")
    private String lastName;

    @NonNull
    @Column(name = "username")
    private String userName;

    @NonNull
    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phoneNo;

    @NonNull
    @Column(name = "password")
    private String password;

}
