package com.cardmap.dto.usercard;

import com.cardmap.domain.entity.UserCard;
import lombok.Data;

@Data
public class UserCardInfoDto {

    private Long userCardSeq;
    private String cardNo;
    private String cardNickname;
    private String companyName;

    public UserCardInfoDto(UserCard userCard) {
        this.userCardSeq = userCard.getSeq();
        this.cardNo = userCard.getCardNo();
        this.cardNickname = userCard.getCardNickname();
        this.companyName = userCard.getCardInfo().getCompanyName();
    }
}
