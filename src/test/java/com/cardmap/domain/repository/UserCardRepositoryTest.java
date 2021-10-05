package com.cardmap.domain.repository;

import com.cardmap.domain.entity.UserCard;
import com.cardmap.dto.usercard.CreateUserCardRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
class UserCardRepositoryTest {

    @Autowired
    UserCardRepository userCardRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    @Rollback(false)
    public void repoTest() {
        UserCard userCard1 = UserCard.createUserCard(null, null,
                new CreateUserCardRequest("123", "card1", 2L, "member1", LocalDateTime.now()));

        UserCard userCard2 = UserCard.createUserCard(null, null,
                new CreateUserCardRequest("1234", "card2", 3L, "member1", LocalDateTime.now()));

        userCardRepository.save(userCard1);
        userCardRepository.save(userCard2);

        UserCard findUserCard = userCardRepository.findBySeq(userCard1.getSeq()).get();
        System.out.println("findUserCard = " + findUserCard);

        userCardRepository.deleteBySeq(userCard1.getSeq());
    }
}