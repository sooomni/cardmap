package com.cardmap.dto.cardinfo;

import com.cardmap.domain.entity.AnnualFee;
import com.cardmap.domain.entity.Benefit;
import com.cardmap.domain.entity.CardInfo;
import com.cardmap.domain.enums.CreditStatus;
import com.cardmap.domain.enums.TrafficStatus;
import lombok.Data;

import java.util.List;

@Data
public class CardDetailInfoDto {

    private Long cardInfoSeq;

    private String cardName;

    private String companyName;

    private List<Benefit> benefitList;

    private List<AnnualFee> annualFeeList;

    private TrafficStatus trafficYn;

    private CreditStatus creditYn;

    public CardDetailInfoDto(CardInfo cardInfo) {
        this.cardInfoSeq = cardInfo.getCardInfoSeq();
        this.cardName = cardInfo.getCardName();
        this.companyName = cardInfo.getCompanyName();
        this.benefitList = cardInfo.getBenefitList();
        this.annualFeeList = cardInfo.getAnnualFeeList();
        this.trafficYn = cardInfo.getTrafficYn();
        this.creditYn = cardInfo.getCreditYn();
    }
}
