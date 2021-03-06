package com.cardmap.domain.entity;

import com.cardmap.domain.enums.UseStatus;
import com.cardmap.dto.usercard.CreateUserCardRequest;
import com.cardmap.dto.usercard.UpdateUserCardRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString(of = {"cardNo", "cardNickname", "user", "cardInfo", "status"})
@Table(name = "user_card")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserCard extends BaseInfo {

    @Id @GeneratedValue
    @Column(name = "user_card_seq")
    private Long seq;

    private String cardNo;
    private String cardNickname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_info_seq")
    private CardInfo cardInfo;

    @OneToMany(mappedBy = "userCard", cascade = CascadeType.ALL)
    private final List<CardUseHist> cardUseHistList = new ArrayList<>();

    private LocalDateTime expDate;

    @Enumerated(EnumType.STRING)
    private UseStatus status;

    // 생성자 메서드
    public static UserCard createUserCard(User user, CardInfo cardInfo, CreateUserCardRequest request) {
        UserCard userCard = new UserCard();

        userCard.setUser(user);
        userCard.setCardInfo(cardInfo);
        userCard.cardNo = request.getCardNo();
        userCard.cardNickname = request.getCardNickname();
        userCard.status = UseStatus.USE;
        userCard.expDate = request.getExpDate();

        return userCard;
    }

    // 비즈니스 로직
    public void changeInfo(UpdateUserCardRequest request) {

        if (StringUtils.hasText(request.getCardNickname())) {
            this.cardNickname = request.getCardNickname();
        }

        if (request.getExpDate() != null) {
            this.expDate = request.getExpDate();
        }
    }

    public void changeStatus() {
        if(status.equals(UseStatus.USE)) {
            status = UseStatus.NOT_USE;
        }
        else {
            status = UseStatus.USE;
        }
    }

    // 연관 관계 메서드
    private void setUser(User user) {
        this.user = user;
        user.getUserCardList().add(this);
    }

    private void setCardInfo(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
        cardInfo.getUserCardList().add(this);
    }
}
