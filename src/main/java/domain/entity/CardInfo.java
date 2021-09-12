package domain.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class CardInfo {
    @Id
    @GeneratedValue
    private Long cardInfoSeq;

    private String CardName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserCard userCard;

    @OneToMany(mappedBy = "cardInfo")
    private List<Benefit> benefitList;

    @OneToMany(mappedBy = "cardInfo")
    private List<Benefit> annualfeeList;

    private String companyName;

    @Enumerated(EnumType.STRING)
    private TrafficStatus trafficYn;

    @Enumerated(EnumType.STRING)
    private CreditStatus creditYn;

}
