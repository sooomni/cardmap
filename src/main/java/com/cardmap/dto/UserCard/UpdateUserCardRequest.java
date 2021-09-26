package com.CardMap.dto.UserCard;

import com.CardMap.domain.enums.UseStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateUserCardRequest {
    private String cardNickname;
    private LocalDateTime expDate;
    private UseStatus useStatus;
}
