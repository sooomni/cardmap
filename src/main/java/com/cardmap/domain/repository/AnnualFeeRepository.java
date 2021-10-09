package com.cardmap.domain.repository;

import com.cardmap.domain.entity.AnnualFee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AnnualFeeRepository {
    private final EntityManager em;

    public List<AnnualFee> findByCardInfoSeq(Long cardInfoSeq){
        return em.createQuery("select a from AnnualFee where card_info_seq = :cardInfoSeq")
                .setParameter("cardInfoSeq",cardInfoSeq)
                .getResultList();
    }
}