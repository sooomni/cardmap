package com.cardmap.domain.entity;

import com.cardmap.dto.user.RegistBookmarkRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "bookmark")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Bookmark {

    @Id
    @GeneratedValue
    @Column(name="bookmark_seq")
    private long seq;

    @Column(name="place_id")
    private String placeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    public static Bookmark create(RegistBookmarkRequest request, User user) {
        Bookmark bookmark = new Bookmark();

        bookmark.placeId = request.getPlaceId();
        bookmark.user = user;

        return bookmark;
    }
}
