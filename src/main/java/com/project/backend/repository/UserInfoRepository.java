package com.project.backend.repository;

import com.project.backend.model.Order;
import com.project.backend.model.User;
import com.project.backend.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {

    @Query(" SELECT u FROM UserInfo u  WHERE  u.user.id = (SELECT id FROM User WHERE username = ?1)")
    UserInfo findByUser(String user);

}
