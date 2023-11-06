package com.project.schedulesharing.user.dto;

import com.project.schedulesharing.user.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserPatchDto {
    private String pw;
    private String email;
    private String name;
    private String introduction;
    private String img_path;

    @Builder
    public UserPatchDto(String pw,String email, String name, String introduction, String img_path) {
        this.pw = pw;
        this.email = email;
        this.name = name;
        this.introduction = introduction;
        this.img_path = img_path;
    }

}
