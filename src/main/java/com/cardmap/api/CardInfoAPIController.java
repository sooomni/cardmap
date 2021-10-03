package com.cardmap.api;
import com.cardmap.domain.entity.CardInfo;
import com.cardmap.dto.CardVO;
import com.cardmap.service.CardInfoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cardinfo")
//@RequiredArgsConstructor
public class CardInfoAPIController {
    private final CardInfoService cardInfoService;

    public CardInfoAPIController(CardInfoService cardInfoService) {
        this.cardInfoService = cardInfoService;
    }

    //카드 등록
    @PostMapping("/")
    public void enrollCardInfo(@ModelAttribute("cardvo") CardVO cardVo) {
        CardInfo cardInfo = CardInfo.builder(cardVo).build();
        cardInfoService.createCardInfo(cardInfo);
    }

    //카드 삭제
    @DeleteMapping("/{cardInfoSeq}")
    public void deleteCardInfo(@PathVariable long cardInfoSeq) {
        cardInfoService.deleteCardInfo(cardInfoSeq);
    }

    //카드 수정
    @PutMapping("/{cardInfoSeq}")
    public void modifyCardInfo(@PathVariable long cardInfoSeq, @ModelAttribute("cardvo") CardVO cardVo) {
        CardInfo cardInfo = CardInfo.builder(cardVo).build();
        cardInfoService.updateCardInfo(cardInfoSeq, cardInfo);
    }

    //카드 상세 조회
    @GetMapping("/{cardInfoSeq}")
    public void searchDetailCardInfo(@PathVariable Long cardInfoSeq) {
        cardInfoService.getDetailCardInfo(cardInfoSeq);
    }

    //카드 검색 (목록)
    @GetMapping("/{category}/{keyword}")
    public void modifyCardInfo(@PathVariable String category, @PathVariable String keyword) {
        cardInfoService.getCardInfoByCategoryAndKeyword(category,keyword);
    }

}
