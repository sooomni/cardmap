package com.cardmap.dto.bookmark;

import com.cardmap.domain.entity.Bookmark;
import lombok.Data;


@Data
public class BookmarkDto {
    private String placeId;

    public BookmarkDto(Bookmark bookmark) {
        this.placeId = bookmark.getPlaceId();
    }

    public BookmarkDto(String placeId){
        this.placeId = placeId;
    }
}
