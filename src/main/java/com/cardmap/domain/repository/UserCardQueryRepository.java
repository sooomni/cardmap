package com.cardmap.domain.repository;

import com.cardmap.domain.entity.CardUseHist;
import com.cardmap.dto.usercard.CardUseHistRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserCardQueryRepository {

    private final EntityManager em;

    // 사용자 카드 사용 내역 조회
    public List<CardUseHist> getCardUseHist(String cardNo, CardUseHistRequest request) {
        return em.createQuery(
                        "select " +
                                " from UserCard c" +
                                " join c.cardUseHistList h" +
                                " where 1=1" +
                                " and h.useDate >= :startDate" +
                                " and h.useDate <= :endDate"
                        , CardUseHist.class)
                .setParameter("cardNo", cardNo)
                .setParameter("startDate", request.getStartDate())
                .setParameter("endDate", request.getEndDate())
                .setFirstResult(request.getOffset())
                .setMaxResults(request.getLimit())
                .getResultList();
    }
}