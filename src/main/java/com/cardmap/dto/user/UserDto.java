package com.cardmap.dto.user;

import com.cardmap.domain.entity.Bookmark;
import com.cardmap.domain.entity.User;
import com.cardmap.domain.entity.UserCard;
import com.cardmap.domain.enums.UserStatus;
import com.cardmap.dto.usercard.UserCardInfoDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
public class UserDto {
    private String id;
    private String password;
    private String userName;
    private final List<BookmarkDto> bookmarkList = new ArrayList<>();
    private final List<UserCardInfoDto> userCardList = new ArrayList<>();
    private UserStatus status;
    private String mobile;
    private String modId;
    private String regId;
    private LocalDateTime modDate;
    private LocalDateTime regDate;

    public UserDto(User user) {
        this.id = user.getId();
        this.password = user.getPassword();
        this.userName = user.getUserName();
        addBookmarkList(user.getBookmarkList());
        addUserCardList(user.getUserCardList());
        this.status = user.getStatus();
        this.mobile = user.getMobile();
        this.modId = user.getModId();
        this.regId = user.getRegId();
        this.modDate = user.getModDate();
        this.regDate = user.getRegDate();

    }

    private void addBookmarkList(List<Bookmark> bookmarkList) {
        bookmarkList.forEach(value -> {
            if (value != null) {
                this.bookmarkList.add(new BookmarkDto(value));
            }
        });
    }

    private void addUserCardList(List<UserCard> userCardList) {
        userCardList.forEach(value -> {
            if (value != null) {
                this.userCardList.add(new UserCardInfoDto(value));
            }
        });
    }
}
