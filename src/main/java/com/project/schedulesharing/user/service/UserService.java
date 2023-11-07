package com.project.schedulesharing.user.service;


import com.project.schedulesharing.exception.BusinessExceptionHandler;
import com.project.schedulesharing.exception.ErrorCode;
import com.project.schedulesharing.user.dto.UserPatchDto;
import com.project.schedulesharing.user.dto.UserSaveDto;

import com.project.schedulesharing.user.entity.User;
import com.project.schedulesharing.user.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;


    public void saveUser(UserSaveDto userSaveDto){
        if(existId(userSaveDto.getId())){
            throw new BusinessExceptionHandler(ErrorCode.SAME_ID);
        }
        userRepository.save(userSaveDto.toEntity());
    }




    public void updateUser(String id, UserPatchDto userPatchDto){
        User user = existUser(id);
        UserStatus(user);
        user.updata(userPatchDto.getPw(),userPatchDto.getEmail(),userPatchDto.getName(),userPatchDto.getIntroduction(),userPatchDto.getImg_path());
    }


    public void deleteMenu(String id) {
        User user = existUser(id);
        UserStatus(user);
        user.changeUse(false);
    }

    private static void UserStatus(User user) {
        if (!user.isUserUse()) throw new BusinessExceptionHandler(ErrorCode.ID_NOT_FOUND);
    }

    private User existUser(String userId) {
        Optional<User> op = userRepository.findById(userId);
        User user = op.orElseThrow(() -> new BusinessExceptionHandler(ErrorCode.ID_NOT_FOUND));
        return user;
    }


    protected boolean existId (String id) {
        Optional<User> op = userRepository.findById(id);
        if(op.isEmpty()){
            return false;
        }
        return true;
    }



}
