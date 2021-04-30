package com.ttpl.asd.drukairagentwebportal.auth.service;

import com.ttpl.asd.drukairagentwebportal.dto.UserRegistrationDto;
import com.ttpl.asd.drukairagentwebportal.helper.ResponseMessage;

public interface ChangePasswordService {
    ResponseMessage savePassword(UserRegistrationDto registrationDto);
}
