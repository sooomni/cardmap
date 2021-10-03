package com.cardMap.domain.entity;


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

}
