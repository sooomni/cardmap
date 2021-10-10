package com.cardmap.domain.repository;

import com.cardmap.domain.entity.Bookmark;
import com.cardmap.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    /**
     * 회원 정보 등록
     *
     * @param user
     */
    public void registUser(User user) {
        em.persist(user);
    }

    /**
     * 회원 정보 조회
     * @param userId
     * @return
     */
    public User getUser(String userId) {
        return em.find(User.class, userId);
    }

    public User findUserId(String userName) {
        return em.find(User.class, userName);
    }

    public User findUserPassword(String userName) {
        return em.find(User.class, userName);
    }

    public void registBookmark(Bookmark bookmark) {
        em.persist(bookmark);
    }

    public void removeBookmark(String userId, String placeId) {
        User user = em.find(User.class, userId);
        em.createQuery(
                        "delete from Bookmark" +
                                " where userId =: userId" +
                                " and plcaeId =: placeId"
                        , Bookmark.class
                )
                .setParameter("userId", userId)
                .setParameter("placeId", placeId);
    }

    public List<Bookmark> getBookmarkList(String userId) {
        return em.createQuery(
                        "select * from Bookmark" +
                                " where userId = :userId"
                        , Bookmark.class
                )
                .setParameter("userId", userId)
                .getResultList();
    }
}
