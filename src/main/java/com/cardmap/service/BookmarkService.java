package com.cardmap.service;

import com.cardmap.domain.repository.BookmarkRepository;
import com.cardmap.dto.bookmark.BookmarkDto;
import com.cardmap.dto.bookmark.RegistBookmarkRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    public void registBookmark(RegistBookmarkRequest request) {

    }

    public void deleteBookmark(String userId, String placeId) {

    }

    public List<BookmarkDto> getBookmarks(String userId) {
        return null;
    }
}
