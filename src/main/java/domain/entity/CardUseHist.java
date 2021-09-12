package domain.entity;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class CardUseHist {

    @Id
    @GeneratedValue
    private Long cardUseHistSeq;

    @ManyToOne
    @JoinColumn(name = "cardUseHist")
    private UserCard userCard;

    private LocalDateTime useDate;
    private Long useAmt;
}
