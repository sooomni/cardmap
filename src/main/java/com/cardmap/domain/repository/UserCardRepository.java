package com.CardMap.domain.repository;

import com.CardMap.domain.entity.CardUseHist;
import com.CardMap.domain.entity.UserCard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserCardRepository {

    private final EntityManager em;

    // 사용자 카드 상세 조회
    public UserCard getUserCard(String cardNo) {
        return em.find(UserCard.class, cardNo);
    }

    // 사용자 카드 목록 조회
    public List<UserCard> getUserCardList() {
        return em.createQuery(
                "select uc from UserCard uc"
                , UserCard.class
        ).getResultList();
    }

    // 사용자 카드 사용 내역 조회
    public List<CardUseHist> getCardUseHist(LocalDateTime start, LocalDateTime end) {
        return em.createQuery(
                        "select h from CardUseHist h" +
                                " where h.useDate >= :start" +
                                " and h.useDate <= :end"
                        , CardUseHist.class
                )
                .setParameter("start", start)
                .setParameter("end", end)
                .getResultList();

    }

    // 사용자 카드 등록
    public String registUserCard(UserCard userCard) {
        em.persist(userCard);
        UserCard saved = em.find(UserCard.class, userCard.getCardNo());

        return saved.getCardNo();
    }

    // 사용자 카드 삭제
    public void removeUserCard(String cardNo) {
        UserCard removeCard = em.find(UserCard.class, cardNo);
        em.remove(removeCard);
    }
}
