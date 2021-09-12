package domain.entity;


import javax.persistence.*;

@Entity
public class AnnualFee {

    @Id
    @GeneratedValue
    @Column(name="annual_fee_seq")
    private Long annualFeeSeq;

    @JoinColumn(name="card_info_seq")
    @ManyToOne
    private CardInfo cardInfo;

    private String cardBrand;

    private long fee;

}
