package com.project.schedulesharing.user.service;


import com.project.schedulesharing.exception.BusinessExceptionHandler;
import com.project.schedulesharing.exception.ErrorCode;
import com.project.schedulesharing.user.dto.UserPatchDto;
import com.project.schedulesharing.user.dto.UserSaveDto;

import com.project.schedulesharing.user.entity.User;
import com.project.schedulesharing.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;


    public void saveUser(UserSaveDto userSaveDto){
        userRepository.save(userSaveDto.toEntity());
    }


    public void updateUser(String id, UserPatchDto userPatchDto){
        User user = userRepository.findById(id).orElseThrow(() -> new BusinessExceptionHandler(ErrorCode.ID_NOT_FOUND));
        user.updata(userPatchDto.getPw(),userPatchDto.getEmail(),userPatchDto.getName(),userPatchDto.getIntroduction(),userPatchDto.getImg_path());
    }



}
