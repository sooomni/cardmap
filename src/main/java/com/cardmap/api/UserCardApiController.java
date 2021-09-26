package com.CardMap.api;

import com.CardMap.domain.entity.CardUseHist;
import com.CardMap.domain.entity.UserCard;
import com.CardMap.domain.repository.UserCardRepository;
import com.CardMap.dto.CreateUserCardRequest;
import com.CardMap.dto.UpdateUserCardRequest;
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
    public UserCard getUserCard(@PathVariable("userCardSeq") Long seq) {
        return userCardRepository.getUserCard(seq);
    }

    /**
     * 사용자 카드 목록 조회
     * @param userId 사용자 아이디
     * @return 사용자 카드 목록
     */
    @GetMapping("/{userId}")
    public List<UserCard> getUserCardList(@PathVariable("userId") String userId) {
        return userCardRepository.getUserCardList(userId);
    }

    /**
     * 사용자 카드 등록
     * @param request 등록할 카드 정보
     * @return 등록 카드 정보
     */
    @PostMapping("")
    public UserCard registUserCard(@RequestBody @Valid CreateUserCardRequest request) {
        Long userCardSeq = userCardService.registUserCard(request);
        return userCardRepository.getUserCard(userCardSeq);
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
     * @param seq 카드 일련 번호
     * @param startDate 시작 기준일
     * @param endDate 종료 기준일
     * @return 카드 사용 내역 목록
     */
    @GetMapping("/history/{userCardSeq}")
    public List<CardUseHist> getCardUseHist(
            @PathVariable("userCardSeq") Long seq,
            @RequestParam("startDate") LocalDateTime startDate,
            @RequestParam("endDate") LocalDateTime endDate) {

        return userCardService.getCardUseHist(seq, startDate, endDate);
    }

}
