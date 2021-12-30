package com.example.service.service;

import com.example.service.entity.UserEntity;
import com.example.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    public UserEntity update(Long id, UserEntity user) {
        if (user.getId() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Id should not be provided");
        Optional<UserEntity> existingEmployee = userRepository.findById(id);
        if (existingEmployee.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");

        user.setId(id);
        return userRepository.save(user);
    }

    //soft delete
    public UserEntity delete(Long id, UserEntity user) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");

        user.setDeleted(true);
        return userRepository.save(user);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        UserDetails userDetails = User.withUsername(userEntity.getUserName()).password(userEntity.getPassword())
                .authorities(userEntity.getUserName())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false).disabled(false).build();

        return userDetails;
    }
}
