package com.project.schedulesharing.user.controller;


import com.project.schedulesharing.user.dto.UserSaveDto;
import com.project.schedulesharing.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    public final UserService userService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody UserSaveDto userSaveDto){
        userService.save(userSaveDto);
        return ResponseEntity.created(URI.create("/user")).build();
    }
}
