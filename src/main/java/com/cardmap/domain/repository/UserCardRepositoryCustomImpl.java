package com.cardmap.domain.repository;

import com.cardmap.domain.entity.UserCard;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
public class UserCardRepositoryCustomImpl implements UserCardRepositoryCustom {

    private final EntityManager em;

    @Override
    public void registUserCard(UserCard userCard) {
        em.persist(userCard);
    }
}
