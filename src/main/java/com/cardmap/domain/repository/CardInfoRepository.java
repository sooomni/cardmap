package com.cardmap.domain.repository;

import lombok.RequiredArgsConstructor;
import com.cardmap.domain.entity.CardInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CardInfoRepository {
    private final EntityManager em;

  public List<CardInfo> findAll(){
      String jpql = "select c from CardInfo";
      return em.createQuery(jpql, CardInfo.class).getResultList();
  }
  public CardInfo findByCardInfoSeq(Long cardInfoSeq){
      return em.find(CardInfo.class,cardInfoSeq);
  }

  public void deleteByCardInfoSeq(Long cardInfoSeq){
      CardInfo removeCard = em.find(CardInfo.class,cardInfoSeq);
      em.remove(removeCard);
  }
  public void save(CardInfo cardInfo){
      em.persist(CardInfo.class);
  }
  public List<CardInfo> findCardInfoByKeyword(String keyword){
      String jpql = "select c from CardInfo c where card_name=:category or company_name=:category";
      return em.createQuery(jpql, CardInfo.class)
              .setParameter("keyword", keyword)
              .getResultList();
  }
}