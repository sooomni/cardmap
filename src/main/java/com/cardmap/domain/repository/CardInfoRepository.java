package com.cardmap.domain.repository;

import com.cardmap.domain.entity.CardInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardInfoRepository extends JpaRepository<CardInfo,Long>{

    // 전체 카드 목록 조회
    public List<CardInfo> findAll();

    // 카드 조회
    public Optional<CardInfo> findByCardInfoSeq(Long cardInfoSeq);

    // 카드 삭제
    public void deleteByCardInfoSeq(Long cardInfoSeq);

    // 카드 등록
    public CardInfo save(CardInfo cardInfo);

}