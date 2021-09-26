package com.CardMap.service;

import com.CardMap.domain.entity.CardUseHist;
import com.CardMap.domain.entity.User;
import com.CardMap.domain.entity.UserCard;
import com.CardMap.domain.enums.UseStatus;
import com.CardMap.domain.repository.UserCardRepository;
import com.CardMap.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserCardService {

    private final UserCardRepository userCardRepository;
    private final UserRepository userRepository;

    /**
     * 사용자 카드 등록
     * @param userId 사용자 아이디
     * @param cardNo 카드 번호
     * @param cardName 카드 이름
     * @param cvcNo CVC 번호
     * @return 등록 카드 번호
     */
    @Transactional
    public String registUserCard(String userId, String cardNo, String cardName, String cvcNo) {

        // TODO user find method
        User user = userRepository.findOne(userId);

        UserCard userCard = UserCard.createUserCard(user, cardNo, cardName, cvcNo);
        userCardRepository.registUserCard(userCard);

        return userCard.getCardNo();
    }

    /**
     * 사용자 카드 삭제
     * @param cardNo 카드 번호
     */
    @Transactional
    public void removeUserCard(String cardNo) {
        userCardRepository.removeUserCard(cardNo);
    }

    /**
     * 카드 사용 내역 조회
     * @param cardNo 카드 번호
     * @param startDate 조회 시작일
     * @param endDate 조회 종료일
     * @return 카드 사용 내역 목록
     */
    public List<CardUseHist> getCardUseHist(String cardNo, LocalDateTime startDate, LocalDateTime endDate) {
        return userCardRepository.getCardUseHist(cardNo, startDate, endDate);
    }

    /**
     * 사용자 카드 정보 수정 (카드 이름, 만료일, 사용 상태)
     * @param cardNo 카드 번호
     * @param cardName 카드 이름
     * @param expDate 만료일
     * @param useStatus 사용 상태
     */
    public void updateUserCard(String cardNo, String cardName, LocalDateTime expDate, UseStatus useStatus) {
        UserCard userCard = userCardRepository.getUserCard(cardNo);

        userCard.changeInfo(cardName, expDate, useStatus);
    }
}
