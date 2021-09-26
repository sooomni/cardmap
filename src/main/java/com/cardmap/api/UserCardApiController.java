package com.CardMap.api;

import com.CardMap.domain.entity.CardUseHist;
import com.CardMap.domain.entity.UserCard;
import com.CardMap.domain.enums.UseStatus;
import com.CardMap.domain.repository.UserCardRepository;
import com.CardMap.service.UserCardService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
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
     * @param cardNo 카드 번호
     * @return 사용자 카드 정보
     */
    @GetMapping("/{cardNo}")
    public UserCard getUserCard(@PathVariable("cardNo") String cardNo) {
        return userCardRepository.getUserCard(cardNo);
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
    public UserCard registUserCard(@RequestBody CreateUserCardRequest request) {
        String cardNo = userCardService.registUserCard(request.getUserId(), request.getCardNo(), request.getCardName(), request.getCvcNo());
        return userCardRepository.getUserCard(cardNo);
    }

    /**
     * 사용자 카드 정보 수정
     * @param cardNo 카드 번호
     * @param request 수정할 카드 정보
     */
    @PutMapping("/{cardNo}")
    public void updateUserCard(@PathVariable("cardNo") String cardNo, @RequestBody UpdateUserCardRequest request) {
        userCardService.updateUserCard(cardNo, request.getCardName(), request.getExpDate(), request.getUseStatus());
    }

    /**
     * 사용자 카드 삭제
     * @param cardNo 카드 번호
     */
    @DeleteMapping("/{cardNo}")
    public void removeUserCard(@PathVariable("cardNo") String cardNo) {
        userCardService.removeUserCard(cardNo);
    }

    /**
     * 카드 사용 내역 조회
     * @param cardNo 카드 번호
     * @param startDate 시작 기준일
     * @param endDate 종료 기준일
     * @return 카드 사용 내역 목록
     */
    @GetMapping("/history/{cardNo}")
    public List<CardUseHist> getCardUseHist(
            @PathVariable("cardNo") String cardNo,
            @RequestParam("startDate") LocalDateTime startDate,
            @RequestParam("endDate") LocalDateTime endDate) {

        return userCardService.getCardUseHist(cardNo, startDate, endDate);
    }

    @Data
    private static class CreateUserCardRequest {
        @NotEmpty
        private String cardNo;

        private String cardName;
        private String cvcNo;

        @NotEmpty
        private String userId;
    }

    @Data
    private static class UpdateUserCardRequest {
        private String cardName;
        private LocalDateTime expDate;
        private UseStatus useStatus;
    }
}