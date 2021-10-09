package com.cardmap.domain.repository;

import com.cardmap.domain.entity.Benefit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BenefitRepository {
    private final EntityManager em;

    public List<Benefit> findByCardInfoSeq(Long cardInfoSeq){
      return em.createQuery("select b from Benefit where card_info_seq = :cardInfoSeq")
              .setParameter("cardInfoSeq",cardInfoSeq)
              .getResultList();
  }

    public List<Benefit> findBenefitByCategory(String category) {
        return em.createQuery("select b from Benefit where benefit_categoty = :category")
                .setParameter("category",category)
                .getResultList();
    }
}