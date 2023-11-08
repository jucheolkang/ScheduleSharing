package com.project.schedulesharing.user.controller;


import com.project.schedulesharing.user.dto.UserPatchDto;
import com.project.schedulesharing.user.dto.UserSaveDto;
import com.project.schedulesharing.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    public final UserService userService;

    @PostMapping
    public String save(@RequestBody UserSaveDto userSaveDto){
        userService.saveUser(userSaveDto);
        return "redirect:/login";
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

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        new SecurityContextLogoutHandler().logout(request, response,
                SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }


}
