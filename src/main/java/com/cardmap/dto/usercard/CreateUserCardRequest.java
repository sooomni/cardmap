package com.cardmap.dto.usercard;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CreateUserCardRequest {

    @NotEmpty
    private String userId;

    @NotEmpty
    private String cardNo;

    private String cardNickname;

    @NotEmpty
    private Long cardInfoSeq;

    @NotEmpty
    private LocalDateTime expDate;
}
