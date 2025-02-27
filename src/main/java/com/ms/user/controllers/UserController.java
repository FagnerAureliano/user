package com.ms.user.controllers;

import org.springframework.beans.BeanUtils; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.user.dtos.UserRecordDTO;
import com.ms.user.models.UserModel;
import com.ms.user.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserModel> create(@RequestBody @Valid UserRecordDTO dto) {
        var userModel = new UserModel();
        BeanUtils.copyProperties(dto, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userModel));
    }

}
