package domain.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "bookmark")
public class BookMark {
    @Id
    @Column(name="place_id")
    private String placeId;

    @JoinColumn(name="user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
