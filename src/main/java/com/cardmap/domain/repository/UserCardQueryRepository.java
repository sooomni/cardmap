package com.cardmap.domain.repository;

import com.cardmap.domain.entity.CardUseHist;
import com.cardmap.domain.entity.UserCard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserCardJpaRepository {

    private final EntityManager em;

    // 사용자 카드 상세 조회
    public UserCard getUserCard(Long seq) {
        return em.find(UserCard.class, seq);
    }

    // 사용자 카드 목록 조회
    public List<UserCard> getUserCardList(String userId) {
        return em.createQuery(
                        "select uc from UserCard uc" +
                                " where userId = :userId"
                        , UserCard.class
                )
                .setParameter("userId", userId)
                .getResultList();
    }

    // 사용자 카드 사용 내역 조회
    public List<CardUseHist> getCardUseHist(String cardNo, LocalDateTime startDate, LocalDateTime endDate) {
        return em.createQuery(
                        "select h" +
                                " from CardUseHist h" +
                                " where h.cardNo = :cardNo" +
                                " and h.useDate >= :startDate" +
                                " and h.useDate <= :endDate"
                        , CardUseHist.class
                )
                .setParameter("cardNo", cardNo)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
    }

    // 사용자 카드 등록
    public void registUserCard(UserCard userCard) {
        em.persist(userCard);
    }

    // 사용자 카드 삭제
    public void removeUserCard(Long seq) {

        UserCard removeCard = em.find(UserCard.class, seq);
        em.remove(removeCard);
    }
}
