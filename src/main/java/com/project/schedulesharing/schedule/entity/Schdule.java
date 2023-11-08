package com.project.schedulesharing.schedule.entity;

import com.project.schedulesharing.base.BaseEntity;
import com.project.schedulesharing.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;



@Getter
@NoArgsConstructor
@Entity
@Table(name = "Schdule")
public class Schdule extends BaseEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "TODO_CHECK")
    private Boolean ToDoCheck = false;

    @Column(name = "TODO_USE")
    private Boolean ToDoUse= false;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "MEMO")
    private String memo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "DATE_TIME")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Builder
    public Schdule(boolean ToDoCheck, boolean ToDouse, String title, String memo, Date date, User user){
        this.ToDoUse = ToDouse;
        this.ToDoCheck = ToDoCheck;
        this.title = title;
        this.memo = memo;
        this.date = date;
        this.user = user;

    }
}
