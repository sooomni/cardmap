package com.cardmap.dto.usercard;

import com.cardmap.domain.entity.UserCard;
import com.cardmap.domain.enums.UseStatus;
import lombok.Data;

@Data
public class UserCardInfoDto {

    private Long seq;
    private String cardNo;
    private String cardNickname;
    private UseStatus status;

    public UserCardInfoDto(UserCard userCard) {
        this.seq = userCard.getSeq();
        this.cardNo = userCard.getCardNo();
        this.cardNickname = userCard.getCardNickname();
        this.status = userCard.getStatus();
    }
}
