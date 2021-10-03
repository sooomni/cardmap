package com.cardmap.domain.repository;

import com.cardmap.domain.entity.User;
import com.cardmap.dto.user.DeleteUserRequest;
import com.cardmap.dto.user.FindUserIdRequest;
import com.cardmap.dto.user.FindUserPasswordRequest;
import com.cardmap.dto.user.RegistUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    /**
     * 회원 정보 등록
     * @param user
     */
    public void registUser(RegistUserRequest user){
        em.persist(user);
    }

    /**
     * 회원 정보 수정
     * @param user
     */
    public void registUser(User user){
        em.persist(user);
    }

    /**
     * 회원 정보 조회
     * @param userId
     * @return
     */
    public User getUser(String userId){
        return em.find(User.class, userId);
    }

    public void deleteUser(DeleteUserRequest request){
        em.remove(request.getId(),request.getPassword());
    }

    public User findUserId(FindUserIdRequest request){
        return em.find(User.class, request.getUserName());
    }

    public User findUserPassword(FindUserPasswordRequest request){
        return em.find(User.class, request.getUserName())
    }


}