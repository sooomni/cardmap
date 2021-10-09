package com.cardmap.api;
import com.cardmap.dto.cardinfo.CardDetailInfoDto;
import com.cardmap.dto.cardinfo.CardInfoDto;
import com.cardmap.dto.cardinfo.CreateCardInfoRequest;
import com.cardmap.dto.cardinfo.UpdateCardInfoRequest;
import com.cardmap.service.CardInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/cardinfo")
@RequiredArgsConstructor
public class CardInfoAPIController {
    private final CardInfoService cardInfoService;

    //카드 등록
    @PostMapping("/")
    public Long enrollCardInfo(@RequestBody CreateCardInfoRequest request) {
        return cardInfoService.createCardInfo(request);
    }

    //카드 삭제
    @DeleteMapping("/{cardInfoSeq}")
    public void deleteCardInfo(@PathVariable long cardInfoSeq) {
        cardInfoService.deleteCardInfo(cardInfoSeq);
    }

    //카드 수정
    @PutMapping("/{cardInfoSeq}")
    public void modifyCardInfo(@PathVariable long cardInfoSeq,@RequestBody UpdateCardInfoRequest request) {
        cardInfoService.updateCardInfo(cardInfoSeq, request);
    }

    //카드 상세 조회
    @GetMapping("/{cardInfoSeq}")
    public CardDetailInfoDto searchDetailCardInfo(@PathVariable Long cardInfoSeq) {
        return cardInfoService.getDetailCardInfo(cardInfoSeq);
    }

    //카드 검색 (목록)
    @GetMapping("/{category}/{keyword}")
    public List<CardInfoDto> modifyCardInfo(@PathVariable String category, @PathVariable String keyword) {
        return cardInfoService.getCardInfoByCategoryAndKeyword(category,keyword);
    }

}
