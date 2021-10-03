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
public class BookmarkServiceImpl implements BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    @Override
    public void registBookmark(RegistBookmarkRequest request) {

    }

    @Override
    public void deleteBookmark(String userId, String placeId) {

    }

    @Override
    public List<BookmarkDto> getBookmarks(String userId) {
        return null;
    }
}
