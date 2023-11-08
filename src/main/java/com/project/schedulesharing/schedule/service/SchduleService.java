package com.project.schedulesharing.schedule.service;

import com.project.schedulesharing.base.DateParser;
import com.project.schedulesharing.exception.BusinessExceptionHandler;
import com.project.schedulesharing.exception.ErrorCode;
import com.project.schedulesharing.schedule.dto.ScheduleSaveDto;
import com.project.schedulesharing.schedule.repository.SchduleRepository;
import com.project.schedulesharing.user.dto.UserPatchDto;
import com.project.schedulesharing.user.dto.UserSaveDto;
import com.project.schedulesharing.user.entity.User;
import com.project.schedulesharing.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

import static com.project.schedulesharing.exception.ErrorCode.ID_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional
public class SchduleService {
    private final SchduleRepository schduleRepository;
    private final UserRepository userRepository;
    private final DateParser dateParser;


    public void SaveSchdul(ScheduleSaveDto scheduleSaveDto, String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new BusinessExceptionHandler(ID_NOT_FOUND));
        Date date = dateParser.parseDate(scheduleSaveDto.getDate());
        schduleRepository.save(scheduleSaveDto.toEntity(user, date));
    }

}
