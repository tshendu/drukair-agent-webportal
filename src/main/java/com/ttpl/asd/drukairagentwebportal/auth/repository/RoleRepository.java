package com.ttpl.asd.drukairagentwebportal.auth.repository;

import com.ttpl.asd.drukairagentwebportal.auth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface RoleRepository extends JpaRepository<Role, BigInteger> {

}
