package com.cardmap.dto.cardinfo;
import com.cardmap.domain.entity.AnnualFee;
import com.cardmap.domain.entity.Benefit;
import com.cardmap.domain.enums.CreditStatus;
import com.cardmap.domain.enums.TrafficStatus;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;


@Data
public class CardInfoRequest {

    @NotEmpty
    private String cardName;
    @NotEmpty
    private String companyName;

    private List<BenefitDto> benefitList;

    private List<AnnualFeeDto> annualFeeList;

    private TrafficStatus trafficYn;

    private CreditStatus creditYn;

    public CardInfoRequest(@NotEmpty String cardName, @NotEmpty String companyName, List<BenefitDto> benefitList, List<AnnualFeeDto> annualFeeList, TrafficStatus trafficYn, CreditStatus creditYn) {
        this.cardName = cardName;
        this.companyName = companyName;
        this.benefitList = benefitList;
        this.annualFeeList = annualFeeList;
        this.trafficYn = trafficYn;
        this.creditYn = creditYn;
    }
}
