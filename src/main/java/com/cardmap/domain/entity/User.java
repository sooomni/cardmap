package com.cardMap.domain.entity;

import com.cardMap.domain.enums.UserStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User{

    @Id
    @Column(name = "user_id")
    private String id;

    private String password;

    private String userName;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    private final List<BookMark> bookMarkList = new ArrayList<>();

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    private final List<UserCard> userCardList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private String mobile;

    private String modId;

    private String regId;

    private LocalDateTime modDate;

    private LocalDateTime regDate;
}