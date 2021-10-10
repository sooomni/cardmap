package com.cardmap.dto.cardinfo;

import com.cardmap.domain.entity.AnnualFee;
import com.cardmap.domain.entity.Benefit;
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

    public CardDetailInfoDto(Long cardInfoSeq, String cardName, String companyName, List<Benefit> benefitList, List<AnnualFee> annualFeeList, TrafficStatus trafficYn, CreditStatus creditYn) {
        this.cardInfoSeq = cardInfoSeq;
        this.cardName = cardName;
        this.companyName = companyName;
        this.benefitList = benefitList;
        this.annualFeeList = annualFeeList;
        this.trafficYn = trafficYn;
        this.creditYn = creditYn;
    }
}
