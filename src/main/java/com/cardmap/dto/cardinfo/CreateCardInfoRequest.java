package com.cardmap.dto.cardinfo;
import com.cardmap.domain.enums.CreditStatus;
import com.cardmap.domain.enums.TrafficStatus;
import lombok.*;

import javax.validation.constraints.NotEmpty;


@Data
public class CreateCardInfoRequest {

    @NotEmpty
    private String cardName;
    @NotEmpty
    private String companyName;

    private TrafficStatus trafficYn;

    private CreditStatus creditYn;

    public CreateCardInfoRequest(@NotEmpty String cardName, @NotEmpty String companyName, TrafficStatus trafficYn, CreditStatus creditYn) {
        this.cardName = cardName;
        this.companyName = companyName;
        this.trafficYn = trafficYn;
        this.creditYn = creditYn;
    }
}
