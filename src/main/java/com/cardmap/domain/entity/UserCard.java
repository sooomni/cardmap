package com.CardMap.domain.entity;

import com.CardMap.domain.enums.UseStatus;
import io.micrometer.core.instrument.util.StringUtils;
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
    public static UserCard createUserCard(User user, String cardNo, String cardName, String cvcNo, LocalDateTime expDate) {
        UserCard userCard = new UserCard();

        userCard.setUser(user);
        userCard.cardNo = cardNo;
        userCard.cardName = cardName;
        userCard.cvcNo = cvcNo;
        userCard.status = UseStatus.USE;
        userCard.expDate = expDate;

        return userCard;
    }

    // 비즈니스 로직
    public void changeInfo(String cardName, LocalDateTime expDate, UseStatus useStatus) {
        if(StringUtils.isNotEmpty(cardName)) {
            this.cardName = cardName;
        }

        if(expDate != null) {
            this.expDate = expDate;
        }

        if(useStatus != null) {
            this.status = useStatus;
        }
    }

    // 연관 관계 메서드
    public void setUser(User user) {
        this.user = user;
        user.getUserCardList().add(this);
    }

}
