package com.cardmap.domain.entity;

import com.cardmap.domain.enums.BenefitCategory;
import com.cardmap.domain.enums.BenefitType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "benefit")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Benefit {

    @Id
    @GeneratedValue
    private Long benefitSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_info_seq")
    private CardInfo cardInfo;

    @Enumerated(EnumType.STRING)
    private BenefitType benefitType;

    private String benefitCont;

    @Enumerated(EnumType.STRING)
    private BenefitCategory benefitCategory;

    private String performance;

    // 생성자 메서드
    public static Benefit createBenefit(CardInfo cardInfo, BenefitType benefitType, String benefitCont,BenefitCategory benefitCategory,String performance){
        Benefit benefit = new Benefit();

        benefit.setCardInfo(cardInfo);
        benefit.benefitType = benefitType;
        benefit.benefitCont = benefitCont;
        benefit.benefitCategory = benefitCategory;
        benefit.performance = performance;

        return benefit;
    }

    //연관 관계 메서드
    public void setCardInfo(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
        cardInfo.getBenefitList().add(this);
    }
}
