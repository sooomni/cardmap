package domain.entity;

import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;

public class BookMark {
    @Id
    @Column(name="place_id")
    String placeId;

    @JoinColumn(name="user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    User user;
}
