package com.msvc.user.repository;

import com.msvc.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, String> {
}
