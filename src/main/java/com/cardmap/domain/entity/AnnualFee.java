package com.cardmap.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "annual_fee")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AnnualFee {

    @Id
    @GeneratedValue
    private Long annualFeeSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="card_info_seq")
    private CardInfo cardInfo;

    private String cardBrand;

    private Long fee;

    // 생성자 메서드
    public static AnnualFee createAnnualFee(CardInfo cardInfo, String cardBrand, Long fee){
        AnnualFee annualFee = new AnnualFee();

        annualFee.setCardInfo(cardInfo);
        annualFee.cardBrand = cardBrand;
        annualFee.fee = fee;

        return annualFee;
    }

    //연관 관계 메서드
    public void setCardInfo(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
        cardInfo.getAnnualFeeList().add(this);
    }
}
