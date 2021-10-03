package com.CardMap.domain.entity;

import com.CardMap.domain.enums.BenefitCategory;
import com.CardMap.domain.enums.BenefitType;
import com.CardMap.domain.enums.CreditStatus;
import com.CardMap.domain.enums.TrafficStatus;
import com.CardMap.dto.CardVO;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "card_info")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder(builderMethodName = "CardInfoBuilder")
public class CardInfo {
    @Id
    @GeneratedValue
    private Long cardInfoSeq;

    private String cardName;

    //@OneToMany(fetch = FetchType.LAZY)
    //@JoinColumn(name = "user_id")
    //private UserCard userCard;
    @OneToMany(mappedBy = "cardInfo", cascade = CascadeType.ALL)
    private List<UserCard> userCardList = new ArrayList<>();

    @OneToMany(mappedBy = "cardInfo", cascade = CascadeType.ALL)
    private List<Benefit> benefitList = new ArrayList<>();

    @OneToMany(mappedBy = "cardInfo", cascade = CascadeType.ALL)
    private List<AnnualFee> annualFeeList = new ArrayList<>();

    private String companyName;

    @Enumerated(EnumType.STRING)
    private TrafficStatus trafficYn;

    @Enumerated(EnumType.STRING)
    private CreditStatus creditYn;

    //@Enumerated(EnumType.STRING)
    private List<BenefitCategory> benefitCategoryList;

    @Enumerated(EnumType.STRING)
    private BenefitType benefittype;

    public static CardInfoBuilder builder(CardVO cardVo) {
        return CardInfoBuilder()
                .cardInfoSeq(cardVo.getCardInfoSeq())
                .cardName(cardVo.getCardName())
                .benefitList(cardVo.getBenefitList())
                .annualFeeList(cardVo.getAnnualFeeList())
                .companyName(cardVo.getCompanyName())
                .trafficYn(cardVo.getTrafficYn())
                .creditYn(cardVo.getCreditYn())
                .benefitCategoryList(cardVo.getBenefitCategoryList())
                .benefittype(cardVo.getBenefittype());
    }
}
