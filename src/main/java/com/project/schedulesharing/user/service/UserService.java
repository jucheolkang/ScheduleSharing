package com.project.schedulesharing.user.service;


import com.project.schedulesharing.user.dto.UserSaveDto;
import com.project.schedulesharing.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void save(UserSaveDto userSaveDto){
        userRepository.save(userSaveDto.toEntity());
    }




}
