package com.cardmap.domain.repository;

import com.cardmap.domain.entity.CardUseHist;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserCardQueryRepository {

    private final EntityManager em;

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
}
