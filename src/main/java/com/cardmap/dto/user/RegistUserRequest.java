package com.cardmap.dto.user;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RegistUserRequest {

    @NotEmpty
    private String username;

    @NotEmpty
    private String id;

    @NotEmpty
    private String password;

    @NotEmpty
    private String mobile;
}
