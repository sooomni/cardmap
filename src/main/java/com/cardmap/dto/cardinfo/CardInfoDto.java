package com.cardmap.dto.cardinfo;

import com.cardmap.domain.entity.AnnualFee;
import com.cardmap.domain.entity.Benefit;
import com.cardmap.domain.entity.CardInfo;
import com.cardmap.domain.enums.BenefitCategory;
import com.cardmap.domain.enums.BenefitType;
import com.cardmap.domain.enums.CreditStatus;
import com.cardmap.domain.enums.TrafficStatus;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class CardInfoDto {

    private String cardInfoSeq;

    private String cardName;

    private String companyName;

    private List<Benefit> benefitList;

    private List<AnnualFee> annualFeeList;

    private TrafficStatus trafficYn;

    private CreditStatus creditYn;

    public CardInfoDto(CardInfo cardInfo){
        this.cardName = cardInfo.getCardName();
        this.companyName = cardInfo.getCompanyName();
        this.benefitList = cardInfo.getBenefitList();
        this.annualFeeList = cardInfo.getAnnualFeeList();
        this.trafficYn = cardInfo.getTrafficYn();
        this.creditYn = cardInfo.getCreditYn();
    }
}
