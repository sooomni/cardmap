package com.cardmap.domain.entity;

import com.cardmap.domain.enums.BenefitCategory;
import com.cardmap.domain.enums.BenefitType;
import com.cardmap.dto.cardinfo.BenefitDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
    public static Benefit createBenefit(CardInfo cardInfo, BenefitDto benefitDto){
        Benefit benefit = new Benefit();

        benefit.benefitType = benefitDto.getBenefitType();
        benefit.benefitCont = benefitDto.getBenefitCont();
        benefit.benefitCategory = benefitDto.getBenefitCategory();
        benefit.performance = benefitDto.getPerformance();
        benefit.setCardInfo(cardInfo);

        return benefit;
    }
    //연관 관계 메서드
    public void setCardInfo(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
        cardInfo.getBenefitList().add(this);
    }
}
