package com.cardmap.domain.entity;

import com.cardmap.domain.enums.UserStatus;
import com.cardmap.dto.user.RegistUserRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @Column(name = "user_id")
    private String id;

    private String password;

    private String userName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private final List<Bookmark> bookmarkList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private final List<UserCard> userCardList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private String mobile;

    private String modId;

    private String regId;

    private LocalDateTime modDate;

    private LocalDateTime regDate;

    // 생성자 메서드
    public static User createUser(String id, String password, String userName, UserStatus status, String mobile, String modId, String regId, LocalDateTime modDate, LocalDateTime regDate) {
        User user = new User();

        user.id = id;
        user.password = password;
        user.userName = userName;
        user.status = status;
        user.mobile = mobile;
        user.modId = modId;
        user.regId = regId;
        user.modDate = modDate;
        user.regDate = regDate;

        return user;
    }

    public static User createUser(RegistUserRequest request) {
        User user = new User();
        user.id = request.getId();
        user.password = request.getPassword();
        user.userName = request.getUsername();
        user.mobile = request.getMobile();

        return user;
    }

    // 연관 관계 메서드
    private void setBookmarkList(List<Bookmark> bookmarkList) {
        if (!bookmarkList.isEmpty()) {
            bookmarkList.forEach(value -> {
                if (value != null) {
                    this.bookmarkList.add(value);
                }
            });
        }
    }

    // 연관 관계 메서드
    private void setUserCardList(List<UserCard> userCardList) {
        if (!userCardList.isEmpty()) {
            userCardList.forEach(value -> {
                if (value != null) {
                    this.userCardList.add(value);
                }
            });
        }
    }

    public void changeInfo(String mobile) {
        if (mobile != null) {
            this.mobile = mobile;
        }
    }

    public void leaveAccount() {
//        this.status = 탈퇴코드;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", status=" + status +
                ", mobile='" + mobile + '\'' +
                ", modId='" + modId + '\'' +
                ", regId='" + regId + '\'' +
                ", modDate=" + modDate +
                ", regDate=" + regDate +
                '}';
    }
}