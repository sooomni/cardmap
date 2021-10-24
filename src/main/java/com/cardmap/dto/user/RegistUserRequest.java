package com.cardmap.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
