package com.cardmap.dto.bookmark;

import lombok.Data;
import com.CardMap.domain.entity.Bookmark;

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
