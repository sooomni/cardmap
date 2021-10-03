package com.cardmap.dto.usercard;

import com.cardmap.domain.entity.UserCard;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserCardDetailInfoDto {

    private String cardNickname;
    private String companyName;
    private String cardName;
    private LocalDateTime expDate;
    private LocalDateTime regDate;

    public UserCardDetailInfoDto(UserCard userCard) {
        this.cardNickname = userCard.getCardNickname();
        this.companyName = userCard.getCardInfo().getCompanyName();
        this.cardName = userCard.getCardInfo().getCardName();
        this.expDate = userCard.getExpDate();
        this.regDate = userCard.getRegDate();
    }
}
