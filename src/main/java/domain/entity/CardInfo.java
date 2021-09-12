package domain.entity;

import javax.persistence.*;
import java.util.List;

public class CardInfo {
    @Id
    @GeneratedValue
    private Long cardInfoSeq;

    private String CardName;

    @OneToMany(mappedBy = "cardInfo")
    private List<Benefit> benefitList;

    @OneToMany(mappedBy = "AnnualFee")
    private List<Benefit> annualfeeList;

    private String companyName;

    @Enumerated(EnumType.STRING)
    private TrafficStatus trafficYn;

    @Enumerated(EnumType.STRING)
    private CreditStatus creditYn;

}
