package com.project.schedulesharing.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User implements UserDetails {

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

    @Column
    private boolean UserUse = true;

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

    public void changeUse(boolean Useruse){
        this.UserUse = Useruse;
    }


    @Override // 권한 반환
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override // 사용자의 패스워드 반환
    public String getPassword() {
        return null;
    }

    @Override //사용자의 id 반환 (고유한 값)
    public String getUsername() {
        return null;
    }


    @Override // 계정 만료 여부 반환
    public boolean isAccountNonExpired() {
        return false;// true : 잠금 x
    }


    @Override // 계정 잠금 여부 반환
    public boolean isAccountNonLocked() {
        return false;
    }


    @Override // 패스워드 만료 여부 반환
    public boolean isCredentialsNonExpired() {
        return false;
    }


    @Override // 계정 사용 가능 여부 반환
    public boolean isEnabled() {
        return false;
    }
}
