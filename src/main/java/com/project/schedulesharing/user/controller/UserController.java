package com.project.schedulesharing.user.controller;


import com.project.schedulesharing.user.dto.UserPatchDto;
import com.project.schedulesharing.user.dto.UserSaveDto;
import com.project.schedulesharing.user.repository.UserRepository;
import com.project.schedulesharing.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    public final UserService userService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody UserSaveDto userSaveDto){
        userService.saveUser(userSaveDto);
        return ResponseEntity.created(URI.create("/user")).build();
    }

    @PatchMapping("/{userId}")
    public ResponseEntity updateUser (@PathVariable String userId, @RequestBody UserPatchDto userPatchDto) {
        userService.updateUser(userId, userPatchDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteMenu (@PathVariable String userId) {
        userService.deleteUser(userId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
