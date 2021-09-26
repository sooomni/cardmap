package com.CardMap.service;

import com.CardMap.domain.entity.CardInfo;
import com.CardMap.domain.entity.CardUseHist;
import com.CardMap.domain.entity.User;
import com.CardMap.domain.entity.UserCard;
import com.CardMap.domain.repository.UserCardRepository;
import com.CardMap.domain.repository.UserRepository;
import com.CardMap.dto.CreateUserCardRequest;
import com.CardMap.dto.UpdateUserCardRequest;
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
    private final CardInfoRepository cardInfoRepository;

    /**
     * 사용자 카드 등록
     * @param request 등록 카드 정보
     * @return 등록 카드 번호
     */
    @Transactional
    public Long registUserCard(CreateUserCardRequest request) {

        // TODO user find method, cardInfo find method
        User user = userRepository.findOne(userId);
        CardInfo cardInfo = cardInfoRepository.findOne(request.getCardInfoSeq());

        UserCard userCard = UserCard.createUserCard(user, cardInfo, request.getCardNo(), request.getCardNickname(), request.getExpDate());
        userCardRepository.registUserCard(userCard);

        return userCard.getSeq();
    }

    /**
     * 사용자 카드 삭제
     * @param seq 카드 일련 번호
     */
    @Transactional
    public void removeUserCard(Long seq) {
        userCardRepository.removeUserCard(seq);
    }

    /**
     * 카드 사용 내역 조회
     * @param seq 카드 일련 번호
     * @param startDate 조회 시작일
     * @param endDate 조회 종료일
     * @return 카드 사용 내역 목록
     */
    public List<CardUseHist> getCardUseHist(Long seq, LocalDateTime startDate, LocalDateTime endDate) {
        return userCardRepository.getCardUseHist(seq, startDate, endDate);
    }

    /**
     * 사용자 카드 정보 수정 (카드 이름, 만료일, 사용 상태)
     * @param seq 카드 일련 번호
     * @param request 카드 수정 정보
     */
    public void updateUserCard(Long seq, UpdateUserCardRequest request) {
        UserCard userCard = userCardRepository.getUserCard(seq);

        userCard.changeInfo(request.getCardNickname(), request.getExpDate(), request.getUseStatus());
    }
}
