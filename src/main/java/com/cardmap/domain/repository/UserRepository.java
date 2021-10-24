package com.cardmap.domain.repository;

import com.cardmap.domain.entity.Bookmark;
import com.cardmap.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    // ID를 통한 User 조회
    User findById(String Id);

    // 사용자명을 통한 ID 조회
    User findByUserName(String userName);

    // 사용자명을 통한 Password 조회
    User findUserPasswordByUserName(String userName);
}
