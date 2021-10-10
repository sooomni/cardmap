package com.cardmap.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@ToString(of = {"seq", "useDate", "useAmt"})
@Table(name = "card_use_hist")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CardUseHist extends BaseInfo {

    @Id
    @GeneratedValue
    @Column(name = "card_use_hist_seq")
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_card_seq")
    private UserCard userCard;

    private LocalDateTime useDate;
    private Long useAmt;

    // 생성자 메서드
    public static CardUseHist createCardUseHist(UserCard userCard, LocalDateTime useDate, Long useAmt) {
        CardUseHist cardUseHist = new CardUseHist();

        cardUseHist.setUserCard(userCard);
        cardUseHist.useDate = useDate;
        cardUseHist.useAmt = useAmt;

        return cardUseHist;
    }

    // 연관 관계 메서드
    private void setUserCard(UserCard userCard) {
        this.userCard = userCard;
        userCard.getCardUseHistList().add(this);
    }
}
