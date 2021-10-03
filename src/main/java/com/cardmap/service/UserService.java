package com.cardmap.service;

import com.cardmap.dto.user.*;

public interface UserService {
    public UserDto getUser(String userId);

    public void registUser(RegistUserRequest request);

    public void updateUser(UpdateUserRequest request);

    void deleteUser(DeleteUserRequest request);

    void findUserId(FindUserIdRequest request);

    void findUserPassword(FindUserPasswordRequest request);
}
