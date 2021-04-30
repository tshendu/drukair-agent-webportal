package com.ttpl.asd.drukairagentwebportal.auth.repository;

import com.ttpl.asd.drukairagentwebportal.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UserRepository extends JpaRepository<User, BigInteger> {
    User findByUsername(String username);
//    User findByAgentcode(String agentcode);
//    User findByEmail(String email);
}
