package com.CardMap.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "card_use_hist")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CardUseHist {

    @Id
    @GeneratedValue
    private Long cardUseHistSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cardUseHist")
    private UserCard userCard;

    private LocalDateTime useDate;
    private Long useAmt;

}
