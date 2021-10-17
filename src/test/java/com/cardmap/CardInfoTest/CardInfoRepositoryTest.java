package com.cardmap.CardInfoTest;

import com.cardmap.domain.entity.CardInfo;
import com.cardmap.domain.enums.BenefitCategory;
import com.cardmap.domain.enums.BenefitType;
import com.cardmap.domain.enums.CreditStatus;
import com.cardmap.domain.enums.TrafficStatus;
import com.cardmap.domain.repository.CardInfoQueryRepository;
import com.cardmap.domain.repository.CardInfoRepository;

import com.cardmap.dto.cardinfo.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@SpringBootTest( properties = { "testId=cardInfoTest", "testName=CardInfoRepositoryTest" } )
public class CardInfoRepositoryTest {
    @Autowired
    private CardInfoRepository cardInfoRepository;
    @Autowired
    private CardInfoQueryRepository cardInfoQueryRepository;
    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void create() {
        //given
        int  beforeSize = cardInfoRepository.findAll().size();

        List<BenefitRequest> benefitList = new ArrayList<>();
        benefitList.add(new BenefitRequest(BenefitType.Card, "오픽 수강료 할인", BenefitCategory.ed, "50%"));
        List<AnnualFeeRequest> annualFeeList = new ArrayList<>();
        annualFeeList.add(new AnnualFeeRequest("VISA", 10000L));

        CardInfo cardInfo1 = CardInfo.createCardInfo(new CardInfoRequest("Good choice shinhan", "Shinhan", benefitList, annualFeeList, TrafficStatus.USE, CreditStatus.USE));
        CardInfo cardInfo2 = CardInfo.createCardInfo(new CardInfoRequest("Better choice BC", "BC", benefitList, annualFeeList, TrafficStatus.NOT_USE, CreditStatus.NOT_USE));

        //when
        cardInfoRepository.save(cardInfo1);
        cardInfoRepository.save(cardInfo2);

        //then
        assertEquals(beforeSize+2,cardInfoRepository.findAll().size());
        System.err.println("BEFORE TOTAL SIZE "+beforeSize+" |^| AFTER TOTAL SIZE "+cardInfoRepository.findAll().size());
    }

    @Test
    public void read() {
        //when
        List<CardInfo> cardInfos = cardInfoRepository.findAll();
        //then
        System.err.println("TOTAL SIZE "+cardInfos.size());
    }

    @Test
    public void readDetail() {
        //given
        Long testSeq = 1L;

        //when
        CardInfo cardInfo = cardInfoRepository.findByCardInfoSeq(testSeq).orElseThrow();

        //then
        System.err.println("Found cardInfoSeq "+cardInfo.getCardInfoSeq());
        assertEquals(1L, java.util.Optional.ofNullable(cardInfo.getCardInfoSeq()));
    }

    @Test
    public void delete() {

        //given
        Long testSeq = 1L;
        CardInfo cardInfo = cardInfoRepository.findByCardInfoSeq(testSeq).orElseThrow();

        //when
        cardInfoRepository.deleteByCardInfoSeq(cardInfo.getCardInfoSeq());
    }

    @Test
    public void search() {

        //given
        String testKeywordCompanyName = "BC";
        String testKeywordCardName = "better";

        //when
        List<CardInfo> cardInfosByCompanyName = cardInfoQueryRepository.findCardInfoByCategoryAndKeyword(null,testKeywordCompanyName);
        List<CardInfo> cardInfosByCardName = cardInfoQueryRepository.findCardInfoByCategoryAndKeyword(null,testKeywordCardName);

        //then
        if(cardInfosByCompanyName != null) {
            for (CardInfo c : cardInfosByCompanyName) {
                assertEquals(c.getCompanyName(), testKeywordCompanyName);
                System.err.println("found : "+c.getCardInfoSeq()+" "+c.getCompanyName());
            }
        }
        if(cardInfosByCardName != null) {
            for (CardInfo c : cardInfosByCardName) {
                assertEquals(c.getCompanyName(), testKeywordCardName);
                System.err.println("found : "+c.getCardInfoSeq()+" "+c.getCardName());
            }
        }
    }



}
