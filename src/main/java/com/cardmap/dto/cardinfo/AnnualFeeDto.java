package com.cardmap.dto.cardinfo;

import com.cardmap.domain.entity.CardInfo;
import com.cardmap.domain.enums.BenefitCategory;
import com.cardmap.domain.enums.BenefitType;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class AnnualFeeDto {

    private Long annualFeeSeq;

    private String cardBrand;

    private Long fee;

    public AnnualFeeDto(Long annualFeeSeq, String cardBrand, Long fee){
        this.annualFeeSeq = annualFeeSeq;
        this.cardBrand = cardBrand;
        this.fee = fee;
    }
}
