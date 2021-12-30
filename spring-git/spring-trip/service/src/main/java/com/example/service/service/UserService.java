package com.example.service.service;

import com.example.service.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserEntity save(UserEntity user);

    UserEntity update(Long id, UserEntity user);

    UserEntity delete(Long id, UserEntity user);

    UserDetails loadUserByUsername(String username);
}
