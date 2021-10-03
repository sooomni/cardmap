package com.cardmap.dto;

import com.cardmap.domain.entity.AnnualFee;
import com.cardmap.domain.entity.Benefit;
import com.cardmap.domain.enums.BenefitCategory;
import com.cardmap.domain.enums.BenefitType;
import com.cardmap.domain.enums.CreditStatus;
import com.cardmap.domain.enums.TrafficStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardVO {
    private Long cardInfoSeq;
    private String cardName;
    private String companyName;
    private List<Benefit> benefitList;
    private List<AnnualFee> annualFeeList;
    private TrafficStatus trafficYn;
    private CreditStatus creditYn;
    private List<BenefitCategory> benefitCategoryList;
    private BenefitType benefittype;
}
