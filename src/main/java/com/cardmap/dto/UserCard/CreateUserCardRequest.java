package com.CardMap.dto.UserCard;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
public class CreateUserCardRequest {

    @NotEmpty
    private String cardNo;

    private String cardNickname;

    @NotEmpty
    private Long cardInfoSeq;

    @NotEmpty
    private String userId;

    @NotEmpty
    private LocalDateTime expDate;
}
