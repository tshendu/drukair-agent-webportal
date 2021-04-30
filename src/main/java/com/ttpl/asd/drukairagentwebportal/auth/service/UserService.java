package com.ttpl.asd.drukairagentwebportal.auth.service;

import com.ttpl.asd.drukairagentwebportal.auth.model.User;
import com.ttpl.asd.drukairagentwebportal.dto.UserRegistrationDto;
import com.ttpl.asd.drukairagentwebportal.helper.ResponseMessage;

import java.math.BigInteger;

public interface UserService {

    User findByUsername(String username);

//    User findByAgentcode(String agentcode);

    ResponseMessage getUsers();

    ResponseMessage editUser(String agentCode);

    ResponseMessage save(UserRegistrationDto userRegistrationDto);

//    ResponseMessage update(UserRegistrationDto userRegistrationDto);

}
