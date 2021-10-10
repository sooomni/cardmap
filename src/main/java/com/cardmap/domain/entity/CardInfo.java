package com.cardmap.domain.entity;

import com.cardmap.domain.enums.*;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "card_info")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CardInfo {
    @Id
    @GeneratedValue
    private Long cardInfoSeq;

    private String cardName;

    @OneToMany(mappedBy = "cardInfo", cascade = CascadeType.ALL)
    private final List<UserCard> userCardList = new ArrayList<>();

    @OneToMany(mappedBy = "cardInfo", cascade = CascadeType.ALL)
    private final List<Benefit> benefitList = new ArrayList<>();

    @OneToMany(mappedBy = "cardInfo", cascade = CascadeType.ALL)
    private final List<AnnualFee> annualFeeList = new ArrayList<>();

    private String companyName;

    @Enumerated(EnumType.STRING)
    private TrafficStatus trafficYn;

    @Enumerated(EnumType.STRING)
    private CreditStatus creditYn;

    // 생성자 메서드
    public static CardInfo createCardInfo(String cardName, String companyName, TrafficStatus trafficYn, CreditStatus creditYn) {
        CardInfo cardInfo = new CardInfo();

        cardInfo.cardName = cardName;
        cardInfo.companyName = companyName;
        cardInfo.trafficYn = trafficYn;
        cardInfo.creditYn = creditYn;

        return cardInfo;
    }

    public void changeCardInfo(String cardName, String companyName) {
        if (StringUtils.isNotEmpty(cardName)) {
            this.cardName = cardName;
        }

        if (StringUtils.isNotEmpty(companyName)) {
            this.cardName = companyName;
        }
    }
}