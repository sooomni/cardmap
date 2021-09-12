package domain.entity;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "user_card")
public class UserCard {

    @Id
    @Column(name = "card_no")
    private String cardNo;

    private String cardName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "userCard")
    private List<CardInfo> cardInfoList = new ArrayList<>();

    @OneToMany(mappedBy = "userCard")
    private List<CardUseHist> cardUseHistList;

    private LocalDateTime expDate;
    private String cvcNo;

    @Enumerated(EnumType.STRING)
    private UseStatus status;
}
