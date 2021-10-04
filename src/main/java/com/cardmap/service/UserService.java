package com.cardmap.service;

import com.cardmap.domain.entity.User;
import com.cardmap.domain.repository.UserRepository;
import com.cardmap.dto.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserDto getUser(String userId) {
        UserDto user = new UserDto(userRepository.getUser(userId));
        return user;
    }

    public void registUser(RegistUserRequest request) {
        userRepository.registUser(request);
        return;
    }

    public void updateUser(UpdateUserRequest request) {
        User user = userRepository.getUser(request.getId());
        /**
         * 변화된 정보 삽입( null 체크 필요)
         */
        userRepository.registUser(user);
    }

    public void deleteUser(DeleteUserRequest request) {
        userRepository.deleteUser(request);
    }

    public void findUserId(FindUserIdRequest request) {
        userRepository.findUserId(request);
    }

    public void findUserPassword(FindUserPasswordRequest request) {
        userRepository.findUserPassword(request);
    }
}
