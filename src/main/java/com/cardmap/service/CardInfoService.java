package com.cardmap.service;

import com.cardmap.domain.entity.CardInfo;
import com.cardmap.domain.repository.CardInfoQueryRepository;
import com.cardmap.domain.repository.CardInfoRepository;
import com.cardmap.dto.cardinfo.CardDetailInfoDto;
import com.cardmap.dto.cardinfo.CardInfoDto;
import com.cardmap.dto.cardinfo.CardInfoRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CardInfoService {

    private final CardInfoQueryRepository cardInfoQueryRepository;
    private final CardInfoRepository cardInfoRepository;

    //카드 등록
    @Transactional
    public Long createCardInfo(CardInfoRequest request) {
        CardInfo cardInfo = CardInfo.createCardInfo(request);
        cardInfoRepository.save(cardInfo);
        return cardInfo.getCardInfoSeq();
    }

    //카드 삭제
    @Transactional
    public void deleteCardInfo(Long cardInfoSeq){
        cardInfoRepository.deleteByCardInfoSeq(cardInfoSeq);
    }

    //카드 전체 조회
    public List<CardInfo> getAllCardInfo (){
        return cardInfoRepository.findAll();
    }

    //카드 수정
    @Transactional
    public void updateCardInfo(Long cardInfoSeq, CardInfoRequest request) {
        CardInfo cardInfo = cardInfoRepository.findByCardInfoSeq(cardInfoSeq).orElseThrow();
        cardInfo.changeCardInfo(request);
    }

    //카드 상세 조회
    public CardDetailInfoDto getDetailCardInfo(Long cardInfoSeq) {
        CardInfo cardInfo = cardInfoRepository.findByCardInfoSeq(cardInfoSeq).orElseThrow();
        return new CardDetailInfoDto(cardInfo);
    }

    //카드 검색
    public List<CardInfoDto> getCardInfoByCategoryAndKeyword(String category, String keyword) {
       /* List <CardInfo> cardInfoByCategoryAndKeyword = CardInfoQueryRepository.findCardInfoByCategoryAndKeyword(category,keyword);
        List<CardInfoDto> CardInfoDtoList = new ArrayList<>();
        for(CardInfo cardInfo : cardInfoByCategoryAndKeyword){
            CardInfoDtoList.add(new CardInfoDto(cardInfo));
        }*/
        List<CardInfoDto> CardInfoDtoList = new ArrayList<>();

        return CardInfoDtoList;
    }

}
