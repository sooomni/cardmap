package domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class User{
    @Id
    String id;

    String password;

    String userName;

    @OneToMany(mappedBy="user")
    List<BookMark> bookMarkList;

    @OneToMany(mappedBy="user")
    List<CardInfo> cardInfoList;

    @Enumerated(EnumType.STRING)
    UserStatus status;

    String mobile;

    String modId;

    String regId;

    LocalDateTime modDate;

    LocalDateTime regDate;
}