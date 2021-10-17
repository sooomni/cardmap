package com.cardmap.dto.cardinfo;

import com.cardmap.domain.enums.BenefitCategory;
import com.cardmap.domain.enums.BenefitType;
import lombok.Data;

@Data
public class BenefitDto {

    private Long benefitSeq;

    private BenefitType benefitType;

    private String benefitCont;

    private BenefitCategory benefitCategory;

    private String performance;

    public BenefitDto(BenefitType benefitType, String benefitCont, BenefitCategory benefitCategory,String performance) {
        this.benefitType = benefitType;
        this.benefitCont = benefitCont;
        this.benefitCategory = benefitCategory;
        this.performance =performance;
    }
}
