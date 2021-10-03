package com.cardmap.dto.user;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class FindUserIdRequest {

    @NotEmpty
    private String userName;

}
