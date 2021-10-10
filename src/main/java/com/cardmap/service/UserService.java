package com.cardmap.service;

import com.cardmap.domain.entity.Bookmark;
import com.cardmap.domain.entity.User;
import com.cardmap.domain.repository.UserCardRepository;
import com.cardmap.domain.repository.UserRepository;
import com.cardmap.dto.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final UserCardRepository userCardRepository;

    /**
     * 회원 정보 조회
     * @param userId
     * @return
     */
    public UserDto getUser(String userId) {
        UserDto userDto = new UserDto(userRepository.getUser(userId));
        return userDto;
    }

    /**
     * 회원 등록
     * @param request
     */
    public void registUser(RegistUserRequest request) {
        User user = User.createUser(request);
        userRepository.registUser(user);
        return;
    }

    /**
     * 회원 정보 수정
     * @param userId
     * @param request
     */
    public void updateUser(String userId, UpdateUserRequest request) {
        User user = userRepository.getUser(userId);
        user.changeInfo(request.getMobile());
        return;
    }

    /**
     * 회원 탈퇴 처리
     * @param userId
     * @param request
     */
    public void removeUser(String userId, DeleteUserRequest request) {
        User user = userRepository.getUser(userId);
        user.leaveAccount();
        return;
    }

    public String findUserId(FindUserIdRequest request) {
        String userId = userRepository.findUserId(request.getUserName()).getId();
        return userId;
    }

    public String findUserPassword(FindUserPasswordRequest request) {
        String password = userRepository.findUserPassword(request.getUserName()).getPassword();
        return password;
    }

    public void registBookmark(String userId, RegistBookmarkRequest request) {
        User user = userRepository.getUser(userId);
        Bookmark bookmark = Bookmark.create(request, user);
        userRepository.registBookmark(bookmark);
        return;
    }

    public void removeBookmark(String userId, String placeId) {
        userRepository.removeBookmark(userId, placeId);
        return;
    }

    public List<BookmarkDto> getBookmarks(String userId) {
        return userRepository.getBookmarkList(userId).stream().map(BookmarkDto::new).collect(Collectors.toList());
    }
}
