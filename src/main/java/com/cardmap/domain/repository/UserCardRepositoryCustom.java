package com.cardmap.domain.repository;

import com.cardmap.domain.entity.UserCard;

public interface UserCardRepositoryCustom {

    // 사용자 카드 등록
    void addUserCard(UserCard userCard);
}
