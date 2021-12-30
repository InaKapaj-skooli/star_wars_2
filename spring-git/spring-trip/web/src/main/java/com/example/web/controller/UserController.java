package com.example.web.controller;

import com.example.service.entity.UserEntity;
import com.example.service.mapper.UserMapper;
import com.example.service.model.UserDto;
import com.example.service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDto> save(@PathVariable Long id, @RequestBody UserDto userDto) {
        UserEntity user = UserMapper.fromUserDto(userDto);
        UserEntity savedUser = userService.update(id, user);
        logger.info("The user is saved........");
        return ResponseEntity.ok(UserMapper.fromUser(savedUser));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody UserDto userDto) {
        UserEntity user = UserMapper.fromUserDto(userDto);
        UserEntity updatedUser = userService.save(user);
        logger.info("The user is updated........");
        return ResponseEntity.ok(UserMapper.fromUser(updatedUser));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDto> delete(@PathVariable Long id, @RequestBody UserDto userDto) {
        UserEntity user = UserMapper.fromUserDto(userDto);
        UserEntity deletedUser = userService.delete(id, user);
        logger.info("The user is deleted........");
        return ResponseEntity.ok(UserMapper.fromUser(deletedUser));
    }
}
