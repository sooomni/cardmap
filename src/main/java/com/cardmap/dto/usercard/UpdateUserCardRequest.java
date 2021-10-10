package com.cardmap.dto.usercard;

import com.cardmap.domain.enums.UseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UpdateUserCardRequest {

    private String cardNickname;
    private LocalDateTime expDate;
}
