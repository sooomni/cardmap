package com.cardMap.domain.entity;

import com.cardMap.domain.enums.CreditStatus;
import com.cardMap.domain.enums.TrafficStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "card_info")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CardInfo {

    @Id
    @GeneratedValue
    private Long cardInfoSeq;

    private String CardName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserCard userCard;

    @OneToMany(mappedBy = "cardInfo", cascade = CascadeType.ALL)
    private final List<Benefit> benefitList = new ArrayList<>();

    @OneToMany(mappedBy = "cardInfo", cascade = CascadeType.ALL)
    private final List<Benefit> annualFeeList = new ArrayList<>();

    private String companyName;

    @Enumerated(EnumType.STRING)
    private TrafficStatus trafficYn;

    @Enumerated(EnumType.STRING)
    private CreditStatus creditYn;

}
