package com.cardmap.dto.cardinfo;

import com.cardmap.domain.enums.CreditStatus;
import com.cardmap.domain.enums.TrafficStatus;
import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class UpdateCardInfoRequest {

    private String cardName;

    private String companyName;

}
