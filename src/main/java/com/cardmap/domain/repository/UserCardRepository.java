package com.cardmap.domain.repository;

import com.cardmap.domain.entity.UserCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Main Logic
 */
public interface UserCardRepository extends JpaRepository<UserCard, Long>, UserCardRepositoryCustom {

    // 사용자 카드 상세 정보 조회
    Optional<UserCard> findBySeq(Long seq);

    // 사용자 카드 목록 조회
    List<UserCard> findByUserId(String userId);

    // 사용자 카드 삭제
    void deleteBySeq(Long seq);
}
