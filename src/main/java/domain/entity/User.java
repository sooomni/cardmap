package domain.entity;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "user")
public class User{
    @Id
    private String id;

    private String password;

    private String userName;

    @OneToMany(mappedBy="user")
    private List<BookMark> bookMarkList;

    @OneToMany(mappedBy="user")
    private List<CardInfo> cardInfoList;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private String mobile;

    private String modId;

    private String regId;

    private LocalDateTime modDate;

    private LocalDateTime regDate;
}