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
        setBookmarkList(user.getBookmarkList());
        setUserCardList(user.getUserCardList());
        this.status = user.getStatus();
        this.mobile = user.getMobile();
        this.modId = user.getModId();
        this.regId = user.getRegId();
        this.modDate = user.getModDate();
        this.regDate = user.getRegDate();

    }

    private void setBookmarkList(List<Bookmark> bookmarkList) {
        this.bookmarkList.clear();
        bookmarkList.forEach(value -> {
            if (value != null) {
                this.bookmarkList.add(new BookmarkDto(value.getPlaceId()));
            }
        });
    }

    private void setUserCardList(List<UserCard> userCardList) {
        this.userCardList.clear();
        userCardList.forEach(value -> {
            if (value != null) {
                this.userCardList.add(new UserCardInfoDto(value));
            }
        });
    }
}
