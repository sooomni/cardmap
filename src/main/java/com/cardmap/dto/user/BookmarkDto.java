package com.cardmap.dto.user;

import com.cardmap.domain.entity.Bookmark;
import com.cardmap.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
public class BookmarkDto {
    private long seq;
    private String placeId;
    private User user;

    public BookmarkDto(Bookmark bookmark) {
        this.seq = bookmark.getSeq();
        this.placeId = bookmark.getPlaceId();
        this.user = bookmark.getUser();
    }

    public static List<BookmarkDto> convertToBookmarkList(List<Bookmark> bookmarkList) {
        List<BookmarkDto> bookmarkDtoList = new ArrayList<BookmarkDto>();
        for (Bookmark bookmark : bookmarkList) {
            bookmarkDtoList.add(new BookmarkDto(bookmark.getSeq(), bookmark.getPlaceId(), bookmark.getUser()));
        }
        return bookmarkDtoList;
    }
}
