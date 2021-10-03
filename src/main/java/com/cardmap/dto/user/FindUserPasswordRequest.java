package com.cardmap.dto.user;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class FindUserPasswordRequest {

    @NotEmpty
    private String userName;

    @NotEmpty
    private String id;

}
