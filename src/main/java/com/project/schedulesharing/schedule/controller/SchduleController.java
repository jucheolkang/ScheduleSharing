package com.project.schedulesharing.schedule.controller;

import com.project.schedulesharing.schedule.dto.ScheduleSaveDto;
import com.project.schedulesharing.schedule.service.SchduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
@RestController
@RequestMapping("/schdule")
@RequiredArgsConstructor
public class SchduleController {
    private final SchduleService schduleService;
    @PostMapping("/{userId}")
    public ResponseEntity<Object> save(@RequestBody ScheduleSaveDto scheduleSaveDto, @PathVariable String userId){
        schduleService.SaveSchdul(scheduleSaveDto, userId);
        return ResponseEntity.created(URI.create("/schdule")).build();
    }
}
