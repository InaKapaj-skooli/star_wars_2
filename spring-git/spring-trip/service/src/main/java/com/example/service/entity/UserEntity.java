package com.example.service.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String password;

    private String email;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Trip trip;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Flight flight;

    @ManyToMany
    private List<Role> roles;

    private boolean deleted = Boolean.FALSE;
}
