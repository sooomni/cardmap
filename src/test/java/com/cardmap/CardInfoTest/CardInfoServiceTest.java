package com.cardmap.CardInfoTest;

import com.cardmap.domain.enums.CreditStatus;
import com.cardmap.domain.enums.TrafficStatus;
import com.cardmap.domain.repository.CardInfoRepository;
import com.cardmap.dto.cardinfo.CardInfoRequest;
import com.cardmap.service.CardInfoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest( properties = { "testId=cardInfoTest01", "testName=CardInfoServiceTest" } )
public class CardInfoServiceTest {

    @Autowired
    private CardInfoRepository cardInfoRepository;
    @Autowired
    private CardInfoService cardInfoService;

    @Test
    @Order(1)
    @DisplayName("1) 등록")
    public void create(){
       // cardInfoService.createCardInfo(new CardInfoRequest("참 좋은 신한 카드","신한", TrafficStatus.USE, CreditStatus.USE));
    }

    @Test
    @Order(2)
    @DisplayName("2) 삭제")
    public void delete(){

    }

    @Test
    @Order(3)
    @DisplayName("3) 전체 조회")
    public void findAll(){
        cardInfoService.getAllCardInfo();
    }

    @Test
    @Order(4)
    @DisplayName("4) 수정")
    public void update(){

    }

    @Test
    @Order(5)
    @DisplayName("5) 상세 조회")
    public void findByCardInfoSeq(){
    }

    @Test
    @Order(6)
    @DisplayName("6) 검색")
    public void findByCategoryAndKeyword(){
    }

}
