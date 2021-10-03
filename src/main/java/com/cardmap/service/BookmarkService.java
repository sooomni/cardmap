package com.cardmap.service;

import com.cardmap.dto.bookmark.BookmarkDto;
import com.cardmap.dto.bookmark.RegistBookmarkRequest;

import java.util.List;

public interface BookmarkService {

    public void registBookmark(RegistBookmarkRequest request);

    public void deleteBookmark(String userId, String placeId);

    public List<BookmarkDto> getBookmarks(String userId);
}
