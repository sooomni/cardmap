package com.cardmap.dto.usercard;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CardUseHistRequest {

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private int offset;
    private int limit;
}
