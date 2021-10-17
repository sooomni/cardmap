package com.cardmap.domain.repository;

import com.cardmap.domain.entity.CardInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardInfoRepository extends JpaRepository<CardInfo,Long>{

    public List<CardInfo> findAll();
    public Optional<CardInfo> findByCardInfoSeq(Long cardInfoSeq);
    public void deleteByCardInfoSeq(Long cardInfoSeq);
    public CardInfo save(CardInfo cardInfo);

}