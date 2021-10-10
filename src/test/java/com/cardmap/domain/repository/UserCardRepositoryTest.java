package com.cardmap.domain.repository;

import com.cardmap.domain.entity.CardInfo;
import com.cardmap.domain.entity.CardUseHist;
import com.cardmap.domain.entity.User;
import com.cardmap.domain.entity.UserCard;
import com.cardmap.domain.enums.CreditStatus;
import com.cardmap.domain.enums.TrafficStatus;
import com.cardmap.dto.user.RegistUserRequest;
import com.cardmap.dto.usercard.*;
import com.cardmap.service.UserCardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@Transactional
class UserCardRepositoryTest {

    @Autowired
    UserCardService userCardService;

    @Autowired
    UserCardRepository userCardRepository;

    @Autowired
    UserCardQueryRepository userCardQueryRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    @Rollback(false)
    public void addUserCardTest() {
        User user = getUser();

        CardInfo cardInfo1 = getCardInfo("card1", "KB");
        CardInfo cardInfo2 = getCardInfo("card2", "SH");

        UserCard userCard1 = UserCard.createUserCard(user, cardInfo1,
                new CreateUserCardRequest("123", "card1",  "card1", cardInfo1.getCardInfoSeq(), LocalDateTime.now()));

        UserCard userCard2 = UserCard.createUserCard(user, cardInfo2,
                new CreateUserCardRequest("1234", "card2", "card2", cardInfo2.getCardInfoSeq(), LocalDateTime.now()));
        
        userCardRepository.addUserCard(userCard1);
        userCardRepository.addUserCard(userCard2);

        List<UserCard> resultByRepo = userCardRepository.findByUserId(user.getId());
        System.out.println("##### UserCardList by Repository #####");
        for (UserCard userCard : resultByRepo) {
            System.out.println("userCard = " + userCard);
        }

        List<UserCardInfoDto> userCardList = userCardService.getUserCardList(user.getId());
        System.out.println("##### UserCardList by Service #####");
        for (UserCardInfoDto userCardInfoDto : userCardList) {
            System.out.println("userCardInfoDto = " + userCardInfoDto);
        }

    }

    private CardInfo getCardInfo(String cardName, String companyName) {
        CardInfo card = CardInfo.createCardInfo(cardName, companyName, TrafficStatus.USE, CreditStatus.USE);
        em.persist(card);
        return card;
    }

    private User getUser() {
        RegistUserRequest request = new RegistUserRequest();
        request.setUsername("user1");
        request.setId("user1");
        request.setPassword("1234");
        request.setMobile("1234");
        User user = User.createUser(request);
        em.persist(user);
        return user;
    }

    @Test
    @Rollback(false)
    public void updateUserCardTest() {
        // 사용자, 카드 정보, 사용자 카드 등록
        User user = getUser();

        CardInfo cardInfo1 = getCardInfo("card1", "KB");
        CardInfo cardInfo2 = getCardInfo("card2", "SH");

        UserCard userCard1 = UserCard.createUserCard(user, cardInfo1,
                new CreateUserCardRequest("123", "card1",  "card1", cardInfo1.getCardInfoSeq(), LocalDateTime.now()));

        UserCard userCard2 = UserCard.createUserCard(user, cardInfo2,
                new CreateUserCardRequest("1234", "card2", "card2", cardInfo2.getCardInfoSeq(), LocalDateTime.now()));

        userCardRepository.addUserCard(userCard1);
        userCardRepository.addUserCard(userCard2);

        // 사용자 카드 수정
        userCardService.updateUserCard(userCard1.getSeq(),
                new UpdateUserCardRequest("메롱", LocalDateTime.now()));

        em.flush();
        em.clear();

        UserCard findCard = userCardRepository.findBySeq(userCard1.getSeq()).get();
        System.out.println("findCard = " + findCard);
    }

    @Test
    @Rollback(false)
    public void cardUseHistTest() {
        User user = getUser();

        CardInfo cardInfo1 = getCardInfo("card1", "KB");

        UserCard userCard1 = UserCard.createUserCard(user, cardInfo1,
                new CreateUserCardRequest("123", "card1",  "card1", cardInfo1.getCardInfoSeq(), LocalDateTime.now()));

        userCardRepository.addUserCard(userCard1);

        CardUseHist cardUseHist1 = CardUseHist.createCardUseHist(userCard1, LocalDateTime.now(), 100000L);
        CardUseHist cardUseHist2 = CardUseHist.createCardUseHist(userCard1, LocalDateTime.now(), 200000L);
        CardUseHist cardUseHist3 = CardUseHist.createCardUseHist(userCard1, LocalDateTime.now(), 300000L);

        em.persist(cardUseHist1);
        em.persist(cardUseHist2);
        em.persist(cardUseHist3);

        em.flush();
        em.clear();

        UserCard findCard = userCardRepository.findBySeq(userCard1.getSeq()).get();

        List<CardUseHist> cardUseHist = userCardQueryRepository.getCardUseHist(userCard1.getSeq(),
                new CardUseHistRequest(
                        LocalDateTime.of(1982, 7, 13, 14, 25),
                        LocalDateTime.of(2021, 12, 25, 14, 10),
                        0, 2));

        for (CardUseHist useHist : cardUseHist) {
            System.out.println("useHist = " + useHist);
        }
    }
}