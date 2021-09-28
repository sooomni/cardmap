package com.CardMap.api;

import com.CardMap.domain.repository.UserCardRepository;
import com.CardMap.dto.UserCard.*;
import com.CardMap.service.UserCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usercards")
public class UserCardApiController {

    private final UserCardService userCardService;
    private final UserCardRepository userCardRepository;

    /**
     * 사용자 카드 상세 조회
     * @param seq 카드 일련 번호
     * @return 사용자 카드 정보
     */
    @GetMapping("/{userCardSeq}")
    public UserCardDetailInfoDto getUserCard(@PathVariable("userCardSeq") Long seq) {
        return userCardService.getUserCardInfo(seq);
    }

    /**
     * 사용자 카드 목록 조회
     * @param userId 사용자 아이디
     * @return 사용자 카드 목록
     */
    @GetMapping("/{userId}")
    public List<UserCardInfoDto> getUserCardList(@PathVariable("userId") String userId) {
        return userCardService.getUserCardList(userId);
    }

    /**
     * 사용자 카드 등록
     * @param request 등록할 카드 정보
     * @return 등록 카드 정보
     */
    @PostMapping("")
    public Long registUserCard(@RequestBody @Valid CreateUserCardRequest request) {
        return userCardService.registUserCard(request);
    }

    /**
     * 사용자 카드 정보 수정
     * @param seq 카드 일련 번호
     * @param request 수정할 카드 정보
     */
    @PutMapping("/{userCardSeq}")
    public void updateUserCard(@PathVariable("userCardSeq") Long seq, @RequestBody UpdateUserCardRequest request) {
        userCardService.updateUserCard(seq, request);
    }

    /**
     * 사용자 카드 삭제
     * @param seq 카드 일련 번호
     */
    @DeleteMapping("/{userCardSeq}")
    public void removeUserCard(@PathVariable("userCardSeq") Long seq) {
        userCardService.removeUserCard(seq);
    }

    /**
     * 카드 사용 내역 조회
     * @param cardNo 카드 번호
     * @param startDate 시작 기준일
     * @param endDate 종료 기준일
     * @return 카드 사용 내역 목록
     */
    @GetMapping("/history/{cardNo}")
    public List<CardUseHistDto> getCardUseHist(
            @PathVariable("cardNo") String cardNo,
            @RequestParam("startDate") LocalDateTime startDate,
            @RequestParam("endDate") LocalDateTime endDate) {

        return userCardService.getCardUseHist(cardNo, startDate, endDate);
    }

}
