package com.msvc.user.controller;

import com.msvc.user.entity.UserEntity;
import com.msvc.user.service.IUserService;
import com.msvc.user.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @PostMapping
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity userRequest, HttpServletRequest httpRequest) {
        userRequest.setIpAddress(HttpUtils.getRequestIP(httpRequest));
        UserEntity userEntity = iUserService.saveUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userEntity);
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUser() {
        List<UserEntity> users = iUserService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserEntity> getUser(@PathVariable String userId) {
        UserEntity user = iUserService.getUser(userId);
        return ResponseEntity.ok(user);
    }
}
