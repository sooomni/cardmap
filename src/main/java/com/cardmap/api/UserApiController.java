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
@RequestMapping("/api/")
public class UserApiController {

    private final UserService userService;

    /**
     * 회원 가입
     * @param request
     * @return
     */
    @PostMapping("/users")
    public void registUser(@RequestBody @Valid RegistUserRequest request){
        userService.registUser(request);
        return ;
    }

    /**
     * 회원 정보 조회
     * @param userId
     * @return
     */
    @GetMapping("/users/{userId}")
    public UserDto getUser(@PathVariable("userUd") String userId){
        return userService.getUser(userId);
    }

    /**
     * 회원 정보 수정
     * @param request
     */
    @PutMapping("/users/{userId}")
    public void updateUser(@RequestBody @Valid UpdateUserRequest request){
        userService.updateUser(request);
        return;
    }

    /**
     * 회원 탈퇴
     * @param request
     */
    @PutMapping("/users/delete")
    public void RemoveUser(@PathVariable("userId") DeleteUserRequest request){
        userService.deleteUser(request);
        return;
    }

    /**
     * 아이디 찾기
     * @param request
     */
    @PostMapping("/users/find-id")
    public void findUserId(@RequestBody @Valid FindUserIdRequest request){
        userService.findUserId(request);
        return;
    }

    /**
     * 비밀번호 찾기
     * @param request
     */
    @PostMapping("/users/find-pw")
    public void findUserPassword(@RequestBody @Valid FindUserPasswordRequest request){
        userService.findUserPassword(request);
        return;
    }

    /**
     * 즐겨찾기 등록
     * @param request
     */
    @PostMapping("/users/{userId}/bookmarks")
    public void registBookmark(@RequestBody @Valid RegistBookmarkRequest request){
        userService.registBookmark(request);
        return;
    }

    /**
     * 즐겨찾기 삭제
     * @param userId
     * @param placeId
     */
    @DeleteMapping("/users/{userId}/bookmarks/{placeId}")
    public void deleteBookmark(
            @PathVariable("userId") String userId,
            @PathVariable("plcaeId") String placeId){
        userService.deleteBookmark(userId,placeId);
        return;
    }

    /**
     * 즐겨찾기 목록 조회
     * @param userId
     */
    @GetMapping("/users/{userId}/bookmarks")
    public List<BookmarkDto> getBookmarkList(@PathVariable("userId") String userId){
        return userService.getBookmarks(userId);
    }
}
