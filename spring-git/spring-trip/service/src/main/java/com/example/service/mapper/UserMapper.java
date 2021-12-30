package com.example.service.mapper;

import com.example.service.entity.UserEntity;
import com.example.service.model.UserDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public UserDto fromUser() {
        return fromUser();
    }

    public UserDto fromUser(UserEntity user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUserName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    public UserEntity fromUserDto(UserDto userDto) {
        UserEntity user = new UserEntity();
        user.setId(userDto.getId());
        user.setUserName(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        return user;
    }
}
