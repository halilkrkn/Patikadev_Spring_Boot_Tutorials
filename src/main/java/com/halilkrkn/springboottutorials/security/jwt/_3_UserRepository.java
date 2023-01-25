package com.halilkrkn.springboottutorials.security.jwt;

import org.springframework.data.jpa.repository.JpaRepository;

public interface _3_UserRepository extends JpaRepository<_2_UserEntity,Long> {
    _2_UserEntity findByUsername(String username);
}
