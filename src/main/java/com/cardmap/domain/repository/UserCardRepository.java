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
    public void removeUserCard(String cardNo) {
        UserCard removeCard = em.find(UserCard.class, cardNo);
        em.remove(removeCard);
    }
}