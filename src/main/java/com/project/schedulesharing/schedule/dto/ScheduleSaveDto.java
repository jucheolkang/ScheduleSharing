package com.project.schedulesharing.schedule.dto;

import com.project.schedulesharing.schedule.entity.Schdule;
import com.project.schedulesharing.user.entity.User;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class ScheduleSaveDto {

    private String title;

    private String memo;

    private String date;

    @Builder
    public ScheduleSaveDto(String title, String memo, String date){
        this.title = title;
        this.memo = memo;
        this.date = date;

    }

    @Builder
    public Schdule toEntity(User user, Date date) {
        return Schdule.builder()
                .user(user)
                .memo(memo)
                .title(title)
                .date(date)
                .build();
    }
}
