package com.cardmap.domain.repository;

import com.cardmap.domain.entity.CardInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CardInfoQueryRepository{

    private final EntityManager em;
    //검색
    public List<CardInfo> findCardInfoByCategoryAndKeyword(String category, String keyword){
        return em.createQuery("select " +
                                        "from CardInfo c join c.benefitList b" +
                                        "where c.card_name =:keyword" +
                                        "or c.company_name =:keyword" +
                                        "or b.benefit_categoty = :category",CardInfo.class)
                .setParameter("keyword", keyword)
                .setParameter("category", category)
                .getResultList();
    }
}