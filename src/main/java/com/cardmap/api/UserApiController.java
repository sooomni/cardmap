package com.cardmap.api;

import com.cardmap.dto.user.BookmarkDto;
import com.cardmap.dto.user.RegistBookmarkRequest;
import com.cardmap.dto.user.*;
import com.cardmap.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/")
public class UserApiController {

    private final UserService userService;

    /**
     * 회원 가입
     * @param request
     * @return
     */
    @PostMapping("")
    public void registUser(@RequestBody @Valid RegistUserRequest request){
        userService.registUser(request);
        return ;
    }

    /**
     * 회원 정보 조회
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public UserDto getUser(@PathVariable("userId") String userId){
        return userService.getUser(userId);
    }

    /**
     * 회원 정보 수정
     * @param request
     */
    @PutMapping("/{userId}")
    public void updateUser(@PathVariable("userId") String userId, @RequestBody @Valid UpdateUserRequest request){
        userService.updateUser(userId, request);
        return;
    }

    /**
     * 회원 탈퇴
     * @param request
     */
    @PutMapping("/{userId}/delete")
    public void RemoveUser(@PathVariable("userId") String userId, @RequestBody @Valid  DeleteUserRequest request){
        userService.removeUser(userId, request);
        return;
    }

    /**
     * 아이디 찾기
     * @param request
     */
    @PostMapping("/find-id")
    public String findUserId(@RequestBody @Valid FindUserIdRequest request){
        return userService.findUserId(request);
    }

    /**
     * 비밀번호 찾기
     * @param request
     */
    @PostMapping("/find-pw")
    public String findUserPassword(@RequestBody @Valid FindUserPasswordRequest request){
        return userService.findUserPassword(request);
    }

    /**
     * 즐겨찾기 등록
     * @param request
     */
    @PostMapping("/{userId}/bookmarks")
    public void registBookmark(@PathVariable("userId") String userId, @RequestBody @Valid RegistBookmarkRequest request){
        userService.registBookmark(userId, request);
        return;
    }

    /**
     * 즐겨찾기 삭제
     * @param userId
     * @param placeId
     */
    @DeleteMapping("/{userId}/bookmarks/{placeId}")
    public void deleteBookmark(
            @PathVariable("userId") String userId,
            @PathVariable("plcaeId") String placeId){
        userService.removeBookmark(userId,placeId);
        return;
    }

    /**
     * 즐겨찾기 목록 조회
     * @param userId
     */
    @GetMapping("/{userId}/bookmarks")
    public List<BookmarkDto> getBookmarkList(@PathVariable("userId") String userId){
        return userService.getBookmarks(userId);
    }
}
