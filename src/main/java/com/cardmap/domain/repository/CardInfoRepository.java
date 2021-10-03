package com.cardmap.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cardmap.domain.entity.CardInfo;

import java.util.List;
import java.util.Optional;

public interface CardInfoRepository extends JpaRepository<CardInfo, Long> {

  public List<CardInfo> findAll();
  public Optional<CardInfo> findByCardInfoSeq(Long cardInfoSeq);
  public void deleteByCardInfoSeq(Long cardInfoSeq);
  public CardInfo save(CardInfo cardInfo);
  public List<CardInfo> findCardInfoByCategoryAndKeyword(String category, String keyword);
}