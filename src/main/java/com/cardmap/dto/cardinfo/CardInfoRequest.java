package com.cardmap.dto.cardinfo;
import com.cardmap.domain.entity.AnnualFee;
import com.cardmap.domain.entity.Benefit;
import com.cardmap.domain.enums.CreditStatus;
import com.cardmap.domain.enums.TrafficStatus;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;


@Data
@AllArgsConstructor
public class CardInfoRequest {

    @NotEmpty
    private String cardName;
    @NotEmpty
    private String companyName;

    private List<BenefitDto> benefitList;

    private List<AnnualFeeDto> annualFeeList;

    private TrafficStatus trafficYn;

    private CreditStatus creditYn;
}
