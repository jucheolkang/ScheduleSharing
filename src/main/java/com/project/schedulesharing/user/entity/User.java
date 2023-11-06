package com.project.schedulesharing.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @Column(name = "ID",nullable = false)
    private String id;
    @Column(name = "PW",nullable = false)
    private String pw;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "NAME")
    private String name;
    @Column(name = "INTRODUCTION")
    private String introduction;
    @Column(name = "IMGPATH")
    private String img_path;
    @Column(name = "IDUSE")
    private boolean IdUse = true;
    @Builder
    public User(String id, String pw, String email, String name, String introduction, String img_path) {
        this.id = id;
        this.pw = pw;
        this.email = email;
        this.name = name;
        /*this.roles = roles;*/
        this.introduction = introduction;
        this.img_path = img_path;
    }

    public void updata(String pw,String email, String name, String introduction, String img_path){
        this.pw = pw;
        this.email = email;
        this.name = name;
        this.introduction = introduction;
        this.img_path = img_path;
    }

}
