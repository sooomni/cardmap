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

    private Long cardInfoSeq;

    private String cardName;

    private String companyName;

    public CardInfoDto(Long cardInfoSeq, String cardName, String companyName) {
        this.cardInfoSeq = cardInfoSeq;
        this.cardName = cardName;
        this.companyName = companyName;
    }
}
