package com.msvc.user.service;

import com.msvc.user.entity.UserEntity;

import java.util.List;

public interface IUserService {
    UserEntity saveUser(UserEntity userEntity);

    List<UserEntity> getAllUsers();

    UserEntity getUser(String userId);
}
