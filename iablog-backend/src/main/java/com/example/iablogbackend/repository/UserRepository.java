package com.example.iablogbackend.repository;

import com.example.iablogbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUserName(String userName);
}
