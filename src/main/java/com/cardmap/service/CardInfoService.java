package com.cardmap.service;

import com.cardmap.domain.entity.CardInfo;
import com.cardmap.domain.repository.CardInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class CardInfoService {
    private final CardInfoRepository cardInfoRepository;
    public CardInfoService(CardInfoRepository cardInfoRepository) {
        this.cardInfoRepository = cardInfoRepository;
    }

    //카드 등록
    public CardInfo createCardInfo(CardInfo cardInfo) {
         return cardInfoRepository.save(cardInfo);
    }
    //카드 삭제
    public void deleteCardInfo(Long cardInfoSeq){
        cardInfoRepository.deleteByCardInfoSeq(cardInfoSeq);
    }

    //카드 전체 조회
    //public List<CardInfo> getAllCardInfo { cardInfoRepository.findAll(); }

    //카드 수정
    public void updateCardInfo(long cardInfoSeq, CardInfo cardInfo) {
        //cardInfoRepository.findByCardInfoSeq(cardInfoSeq).ifPresent(cardInfoRepository.save(cardInfo));
    }

    //카드 상세 조회
    public Optional<CardInfo> getDetailCardInfo(long cardInfoSeq) {
        return cardInfoRepository.findByCardInfoSeq(cardInfoSeq);
    }
    //카드 검색
    public List<CardInfo> getCardInfoByCategoryAndKeyword(String category, String keyword) {
        return cardInfoRepository.findCardInfoByCategoryAndKeyword(category,keyword);
    }

}
