package domain.entity;

import javax.persistence.*;

@Entity
public class Benefit {

    @Id
    @GeneratedValue
    @Column(name = "benefit_seq")
    private long benefitSeq;

    @ManyToOne
    @JoinColumn(name = "card_info_seq")
    private CardInfo cardInfo;

    @Enumerated(EnumType.STRING)
    private BenefitType benefitType;

    private String benefitCont;

    @OneToMany
    @JoinColumn(name = "benefitCategory")
    private BenegitCategory benegitCategory;

    private String performance;

}
