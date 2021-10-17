package com.cardmap.dto.cardinfo;

import com.cardmap.domain.entity.CardInfo;
import lombok.Data;

@Data
public class AnnualFeeRequest {

    private String cardBrand;

    private Long fee;

    public AnnualFeeRequest(String cardBrand, Long fee){
        this.cardBrand = cardBrand;
        this.fee = fee;
    }
}
