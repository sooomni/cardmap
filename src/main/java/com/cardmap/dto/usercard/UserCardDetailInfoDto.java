package com.cardmap.dto.usercard;

import com.cardmap.domain.entity.UserCard;
import com.cardmap.domain.enums.UseStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserCardDetailInfoDto {

    private Long seq;
    private String cardNo;
    private String cardNickname;
    private String companyName;
    private String cardName;
    private LocalDateTime expDate;
    private UseStatus status;

    public UserCardDetailInfoDto(UserCard userCard) {
        this.seq = userCard.getSeq();
        this.cardNo = userCard.getCardNo();
        this.cardNickname = userCard.getCardNickname();
        this.companyName = userCard.getCardInfo().getCompanyName();
        this.cardName = userCard.getCardInfo().getCardName();
        this.expDate = userCard.getExpDate();
        this.status = userCard.getStatus();
    }
}
