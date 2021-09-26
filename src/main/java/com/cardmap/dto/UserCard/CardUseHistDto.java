package com.CardMap.dto.UserCard;

import com.CardMap.domain.entity.CardUseHist;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CardUseHistDto {

    private String cardNo;
    private String cardNickname;
    private LocalDateTime useDate;
    private Long useAmount;

    public CardUseHistDto(CardUseHist cardUseHist) {
        this.cardNo = cardUseHist.getUserCard().getCardNo();
        this.cardNickname = cardUseHist.getUserCard().getCardNickname();
        this.useDate = cardUseHist.getUseDate();
        this.useAmount = cardUseHist.getUseAmt();
    }
}
