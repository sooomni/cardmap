package com.cardmap.domain.entity;

import com.cardmap.domain.enums.*;
import com.cardmap.dto.cardinfo.*;
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
public class CardInfo extends BaseInfo {
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
    public static CardInfo createCardInfo(CardInfoRequest cardInfoRequest) {
        CardInfo cardInfo = new CardInfo();

        cardInfo.cardName = cardInfoRequest.getCardName();
        cardInfo.companyName = cardInfoRequest.getCompanyName();
        cardInfo.trafficYn = cardInfoRequest.getTrafficYn();
        cardInfo.creditYn = cardInfoRequest.getCreditYn();

        for(AnnualFeeRequest annualFeeRequest : cardInfoRequest.getAnnualFeeList()) {
            AnnualFee.createAnnualFee(cardInfo,annualFeeRequest);
        }
        for(BenefitRequest benefitRequest : cardInfoRequest.getBenefitList()) {
            Benefit.createBenefit(cardInfo,benefitRequest);
        }
        return cardInfo;
    }

    public void changeCardInfo(CardInfoRequest cardInfoRequest) {
        if (StringUtils.isNotEmpty(cardInfoRequest.getCardName())) {
            this.cardName = cardInfoRequest.getCardName();
        }

        if (StringUtils.isNotEmpty(cardInfoRequest.getCompanyName())) {
            this.cardName = cardInfoRequest.getCompanyName();
        }

        if (cardInfoRequest.getTrafficYn() != null) {
            this.trafficYn = cardInfoRequest.getTrafficYn();
        }

        if (cardInfoRequest.getCreditYn() != null) {
            this.creditYn = cardInfoRequest.getCreditYn();
        }

        if (cardInfoRequest.getAnnualFeeList() != null) {
            for(AnnualFeeRequest annualFeeRequest : cardInfoRequest.getAnnualFeeList()) {
                AnnualFee.createAnnualFee(this,annualFeeRequest);
            }
        }

        if (cardInfoRequest.getBenefitList() != null) {
            for(BenefitRequest benefitRequest : cardInfoRequest.getBenefitList()) {
                Benefit.createBenefit(this,benefitRequest);
            }
        }
    }
}