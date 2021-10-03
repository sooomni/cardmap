package com.cardmap.dto.user;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class DeleteUserRequest {

    @NotEmpty
    private String id;

    @NotEmpty
    private String password;
}
