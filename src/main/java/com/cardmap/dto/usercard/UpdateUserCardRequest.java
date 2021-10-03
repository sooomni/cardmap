package com.cardmap.dto.usercard;

import com.cardmap.domain.enums.UseStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateUserCardRequest {
    private String cardNickname;
    private LocalDateTime expDate;
    private UseStatus useStatus;
}
