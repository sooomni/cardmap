package com.cardmap.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class FindUserPasswordRequest {

    @NotEmpty
    private String userName;

}
