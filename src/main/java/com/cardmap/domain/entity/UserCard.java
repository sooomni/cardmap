package com.CardMap.domain.entity;

import com.CardMap.domain.enums.UseStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "user_card")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserCard {

    @Id
    private String cardNo;

    private String cardName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "userCard", cascade = CascadeType.ALL)
    private final List<CardInfo> cardInfoList = new ArrayList<>();

    @OneToMany(mappedBy = "userCard", cascade = CascadeType.ALL)
    private final List<CardUseHist> cardUseHistList = new ArrayList<>();

    private LocalDateTime expDate;
    private String cvcNo;

    @Enumerated(EnumType.STRING)
    private UseStatus status;
}
