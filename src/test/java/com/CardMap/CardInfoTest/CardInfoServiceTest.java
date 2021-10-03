package com.CardMap.CardInfoTest;

import com.CardMap.domain.entity.AnnualFee;
import com.CardMap.domain.entity.Benefit;
import com.CardMap.domain.entity.CardInfo;
import com.CardMap.domain.enums.BenefitCategory;
import com.CardMap.domain.repository.CardInfoRepository;
import com.CardMap.dto.CardVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.CardMap.domain.enums.BenefitType.*;
import static org.springframework.data.util.Optionals.ifPresentOrElse;

@SpringBootTest
public class CardInfoServiceTest {

    @Autowired
    private CardInfoRepository cardInfoRepository;

    @Test
    @Order(1)
    @DisplayName("1) 등록")
    public void create(){
        List <Benefit> benefitList = new ArrayList<>();
        List <AnnualFee> annualFeeList = new ArrayList<>();
        List <BenefitCategory> benefitCategoryList = new ArrayList<>();
        CardVO cardVo = new CardVO();
        cardVo.setCardInfoSeq((long) 0);
        cardVo.setCardName("참 좋은 신한 카드 ");
        cardVo.setCompanyName("신한");
        cardVo.setBenefitList(benefitList);
        cardVo.setAnnualFeeList(annualFeeList);
        cardVo.setCompanyName("Y");
        cardVo.setCompanyName("N");
        cardVo.setBenefitCategoryList(benefitCategoryList);
        cardVo.setBenefittype(Point);

        CardInfo cardInfo = CardInfo.builder(cardVo).build();
        CardInfo savedCardInfo = cardInfoRepository.save(cardInfo);
        ifPresentOrElse(Optional.ofNullable(savedCardInfo), c -> System.out.println(c.getCardName()), () -> {
            throw new IllegalArgumentException("Invalid cardInfo");
        });
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
        List<CardInfo> cardInfoList= cardInfoRepository.findAll();
        ifPresentOrElse(Optional.ofNullable(cardInfoList), c -> System.out.println("사이즈는 "+c.size()), () -> {
            throw new NullPointerException("cardInfoList is Empty");
        });
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
