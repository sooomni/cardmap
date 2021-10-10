package com.cardmap.service;

import com.cardmap.domain.entity.AnnualFee;
import com.cardmap.domain.entity.Benefit;
import com.cardmap.domain.entity.CardInfo;
import com.cardmap.domain.repository.AnnualFeeRepository;
import com.cardmap.domain.repository.BenefitRepository;
import com.cardmap.domain.repository.CardInfoRepository;
import com.cardmap.dto.cardinfo.CardDetailInfoDto;
import com.cardmap.dto.cardinfo.CardInfoDto;
import com.cardmap.dto.cardinfo.CreateCardInfoRequest;
import com.cardmap.dto.cardinfo.UpdateCardInfoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CardInfoService {

    private final AnnualFeeRepository annualFeeRepository;
    private final BenefitRepository benefitRepository;
    private final CardInfoRepository cardInfoRepository;

    //카드 등록
    @Transactional
    public Long createCardInfo(CreateCardInfoRequest request) {
        CardInfo cardInfo = CardInfo.createCardInfo(request.getCardName(),request.getCompanyName(),request.getTrafficYn(),request.getCreditYn());
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
    public void updateCardInfo(Long cardInfoSeq, UpdateCardInfoRequest request) {
        CardInfo cardInfo = cardInfoRepository.findByCardInfoSeq(cardInfoSeq);
        cardInfo.changeCardInfo(request.getCardName(),request.getCompanyName());

        cardInfoRepository.save(cardInfo);
    }

    //카드 상세 조회
    public CardDetailInfoDto getDetailCardInfo(Long cardInfoSeq) {
        List<AnnualFee> annualFeeList = annualFeeRepository.findByCardInfoSeq(cardInfoSeq);
        List<Benefit> benefitList = benefitRepository.findByCardInfoSeq(cardInfoSeq);
        CardInfo cardInfo = cardInfoRepository.findByCardInfoSeq(cardInfoSeq);

        return new CardDetailInfoDto(cardInfo.getCardInfoSeq(),cardInfo.getCardName(),cardInfo.getCompanyName(), benefitList, annualFeeList,cardInfo.getTrafficYn(),cardInfo.getCreditYn());
    }

    //카드 검색
    public List<CardInfoDto> getCardInfoByCategoryAndKeyword(String category, String keyword) {
        List <CardInfo> keywordList = cardInfoRepository.findCardInfoByKeyword(keyword);
        List <CardInfo> categoryList =   benefitRepository.findBenefitByCategory(category)
                                                          .stream()
                                                          .map(Benefit::getCardInfo)
                                                          .map(cardInfo -> cardInfo.getCardInfoSeq())
                                                          .map(cardInfoRepository::findByCardInfoSeq)
                                                          .collect(Collectors.toList());

        List<CardInfoDto> CardInfoDtoList = new ArrayList<>();
        List <CardInfo> mergetList = Stream.of(keywordList, categoryList)
                        .flatMap(x -> x.stream())
                        .collect(Collectors.toList());
        for(CardInfo c : mergetList){
            CardInfoDtoList.add(new CardInfoDto(c.getCardInfoSeq(), c.getCardName(), c.getCompanyName()));
        }
        return CardInfoDtoList;
    }

}
