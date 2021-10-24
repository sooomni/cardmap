package com.cardmap.service;

import com.cardmap.domain.entity.Bookmark;
import com.cardmap.domain.entity.User;
import com.cardmap.domain.repository.BookmarkRepository;
import com.cardmap.domain.repository.UserCardRepository;
import com.cardmap.domain.repository.UserRepository;
import com.cardmap.dto.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final BookmarkRepository bookmarkRepository;
    private final UserCardRepository userCardRepository;


    /**
     * 회원 정보 조회
     *
     * @param userId
     * @return
     */
    public UserDto getUser(String userId) {
        UserDto userDto = new UserDto(userRepository.findById(userId));
        return userDto;
    }

    /**
     * 회원 등록
     *
     * @param request
     */
    public void registUser(RegistUserRequest request) {
        User user = User.createUser(request);
        userRepository.save(user);
        return;
    }

    /**
     * 회원 정보 수정
     *
     * @param userId
     * @param request
     */
    public void updateUser(String userId, UpdateUserRequest request) {
        User user = userRepository.findById(userId);
        user.changeInfo(request.getMobile());
        return;
    }

    /**
     * 회원 탈퇴 처리
     *
     * @param userId
     * @param request
     */
    public void removeUser(String userId, DeleteUserRequest request) {
        User user = userRepository.findById(userId);
        user.leaveAccount();
        return;
    }

    public String findUserId(FindUserIdRequest request) {
        String userId = userRepository.findByUserName(request.getUserName()).getId();
        return userId;
    }

    public String findUserPassword(FindUserPasswordRequest request) {
        String password = userRepository.findUserPasswordByUserName(request.getUserName()).getPassword();
        return password;
    }

    // Bookmark 등록
    public void registBookmark(String userId, RegistBookmarkRequest request) {
        User user = userRepository.findById(userId);
        Bookmark bookmark = Bookmark.create(request, user);
        bookmarkRepository.save(bookmark);
    }

    // Bookmark 삭제
    public void removeBookmark(long seq) {
        bookmarkRepository.deleteBySeq(seq);
    }

    // Bookmark List 조회
    public List<BookmarkDto> getBookmarks(String userId) {
        List<Bookmark> bookmarkList = (List<Bookmark>) bookmarkRepository.findByUserId(userId);
        List<BookmarkDto> bookmarkDtoList = BookmarkDto.convertToBookmarkList(bookmarkList);
        return bookmarkDtoList;
    }
}
