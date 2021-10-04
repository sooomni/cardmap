package com.cardmap.dto.usercard;

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

    private String userIp;

    @NotEmpty
    private LocalDateTime expDate;
}
