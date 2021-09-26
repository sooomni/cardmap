package com.CardMap.domain.repository;

import com.CardMap.domain.entity.CardUseHist;
import com.CardMap.domain.entity.UserCard;
import com.CardMap.dto.UserCard.CardUseHistDto;
import com.CardMap.dto.UserCard.UserCardDetailInfoDto;
import com.CardMap.dto.UserCard.UserCardInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserCardRepository {

    private final EntityManager em;

    public UserCard getUserCard(Long seq) {
        return em.find(UserCard.class, seq);
    }

    // 사용자 카드 상세 조회
    public UserCardDetailInfoDto getUserCardInfo(Long seq) {

        UserCard userCard = em.find(UserCard.class, seq);
        return new UserCardDetailInfoDto(userCard);
    }

    // 사용자 카드 목록 조회
    public List<UserCardInfoDto> getUserCardList(String userId) {
        List<UserCard> result = em.createQuery(
                        "select uc from UserCard uc" +
                                " where userId = :userId"
                        , UserCard.class
                )
                .setParameter("userId", userId)
                .getResultList();

        return result.stream().map(UserCardInfoDto::new).collect(Collectors.toList());
    }

    // 사용자 카드 사용 내역 조회
    public List<CardUseHistDto> getCardUseHist(Long seq, LocalDateTime startDate, LocalDateTime endDate) {
        List<CardUseHist> result = em.createQuery(
                        "select h" +
                                " from CardUseHist h" +
                                " where h.cardNo = :userCardSeq" +
                                " and h.useDate >= :startDate" +
                                " and h.useDate <= :endDate"
                        , CardUseHist.class
                )
                .setParameter("userCardSeq", seq)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();

        return result.stream().map(CardUseHistDto::new).collect(Collectors.toList());
    }

    // 사용자 카드 등록
    public void registUserCard(UserCard userCard) {
        em.persist(userCard);
    }

    // 사용자 카드 삭제
    public void removeUserCard(Long seq) {

        UserCard removeCard = em.find(UserCard.class, seq);
        em.remove(removeCard);
    }
}
