package com.cardmap.service;

import com.cardmap.domain.entity.CardInfo;
import com.cardmap.domain.entity.User;
import com.cardmap.domain.entity.UserCard;
import com.cardmap.domain.repository.CardInfoRepository;
import com.cardmap.domain.repository.UserCardQueryRepository;
import com.cardmap.domain.repository.UserCardRepository;
import com.cardmap.domain.repository.UserRepository;
import com.cardmap.dto.usercard.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserCardService {

    private final UserCardRepository userCardRepository;
    private final UserCardQueryRepository userCardQueryRepository;
    private final UserRepository userRepository;
    private final CardInfoRepository cardInfoRepository;

    /**
     * 사용자 카드 등록
     * @param request 등록 카드 정보
     * @return 등록 카드 일련 번호
     */
    @Transactional
    public Long addUserCard(CreateUserCardRequest request) {

        User user = userRepository.getUser(request.getUserId());
        CardInfo cardInfo = cardInfoRepository.findByCardInfoSeq(request.getCardInfoSeq());

        UserCard userCard = UserCard.createUserCard(user, cardInfo, request);
        userCardRepository.addUserCard(userCard);

        return userCard.getSeq();
    }

    /**
     * 사용자 카드 정보 수정 (카드 이름, 만료일, 사용 상태)
     * @param seq 카드 일련 번호
     * @param request 카드 수정 정보
     */
    @Transactional
    public void updateUserCard(Long seq, UpdateUserCardRequest request) {
        UserCard userCard = userCardRepository.findBySeq(seq).get();
        userCard.changeInfo(request);
    }

    /**
     * 사용자 카드 상태 수정 (USE -> NOT_USE, NOT_USE -> USE)
     * @param seq
     */
    @Transactional
    public void changeStatus(Long seq) {
        UserCard userCard = userCardRepository.findBySeq(seq).get();
        userCard.changeStatus();
    }

    /**
     * 사용자 카드 삭제
     * @param seq 카드 일련 번호
     */
    @Transactional
    public void removeUserCard(Long seq) {
        userCardRepository.deleteBySeq(seq);
    }

    /**
     * 사용자 카드 상세 조회
     * @param seq 카드 일련 번호
     * @return 카드 상세 정보
     */
    public UserCardDetailInfoDto getUserCardInfo(Long seq) {
        return new UserCardDetailInfoDto(userCardRepository.findBySeq(seq).get());
    }

    /**
     * 사용자 카드 목록 조회
     * @param userId 사용자 아이디
     * @return 카드 목록
     */
    public List<UserCardInfoDto> getUserCardList(String userId) {
        return userCardRepository.findByUserId(userId)
                .stream()
                .map(UserCardInfoDto::new)
                .collect(Collectors.toList());
    }

    /**
     * 카드 사용 내역 조회
     * @param userCardSeq 카드 번호
     * @param request 카드 사용 내역 조회 조건
     * @return 카드 사용 내역 목록
     */
    public List<CardUseHistDto> getCardUseHist(Long userCardSeq, CardUseHistRequest request) {
        return userCardQueryRepository.getCardUseHist(userCardSeq, request)
                .stream()
                .map(CardUseHistDto::new)
                .collect(Collectors.toList());
    }

}
