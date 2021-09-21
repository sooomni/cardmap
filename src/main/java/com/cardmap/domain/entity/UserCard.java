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

    // 생성자 메서드
    public static UserCard createUserCard(User user, String cardNo, String cardName, String cvcNo) {
        UserCard userCard = new UserCard();

        userCard.setUser(user);
        userCard.cardNo = cardNo;
        userCard.cardName = cardName;
        userCard.cvcNo = cvcNo;
        userCard.status = UseStatus.USE;
        userCard.expDate = LocalDateTime.now();

        return userCard;
    }

    // 연관 관계 메서드
    public void setUser(User user) {
        this.user = user;
        user.getUserCardList().add(this);
    }

}
