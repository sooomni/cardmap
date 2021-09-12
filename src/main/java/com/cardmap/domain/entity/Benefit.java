package com.CardMap.domain.entity;

import com.CardMap.domain.enums.BenefitCategory;
import com.CardMap.domain.enums.BenefitType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "benefit")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Benefit {

    @Id
    @GeneratedValue
    private long benefitSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_info_seq")
    private CardInfo cardInfo;

    @Enumerated(EnumType.STRING)
    private BenefitType benefitType;

    private String benefitCont;

    @Enumerated(EnumType.STRING)
    private BenefitCategory benefitCategory;

    private String performance;

}
