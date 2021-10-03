package com.CardMap.domain.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import com.CardMap.domain.entity.CardInfo;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CardInfoRepository extends JpaRepository<CardInfo, Long> {

  public List<CardInfo> findAll();
  public Optional<CardInfo> findByCardInfoSeq(Long cardInfoSeq);
  public void deleteByCardInfoSeq(Long cardInfoSeq);
  public CardInfo save(CardInfo cardInfo);
  public List<CardInfo> findCardInfoByCategoryAndKeyword(String category, String keyword);
}