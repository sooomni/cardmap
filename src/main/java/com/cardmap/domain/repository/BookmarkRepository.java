package com.cardmap.domain.repository;

import com.cardmap.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class BookmarkRepository {

    private final EntityManager em;

}
