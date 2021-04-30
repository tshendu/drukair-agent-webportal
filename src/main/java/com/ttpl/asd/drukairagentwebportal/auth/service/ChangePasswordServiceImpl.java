package com.ttpl.asd.drukairagentwebportal.auth.service;

import com.ttpl.asd.drukairagentwebportal.auth.model.User;
import com.ttpl.asd.drukairagentwebportal.auth.repository.UserRepository;
import com.ttpl.asd.drukairagentwebportal.dto.UserRegistrationDto;
import com.ttpl.asd.drukairagentwebportal.helper.ResponseMessage;
import com.ttpl.asd.drukairagentwebportal.helper.SystemDataInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
public class ChangePasswordServiceImpl implements ChangePasswordService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public ResponseMessage savePassword(UserRegistrationDto registrationDto) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
        if (registrationDto.getOldPassword() == null) {
            responseMessage.setText("Old password is empty.");
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            return responseMessage;
        }
        if (registrationDto.getPassword() == null) {
            responseMessage.setText("New password is empty.");
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            return responseMessage;
        }
        if (registrationDto.getConfirmPassword() == null) {
            responseMessage.setText("Confirm password is empty.");
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            return responseMessage;
        }
        if (registrationDto.getPassword().equals(registrationDto.getOldPassword())) {
            responseMessage.setText("New password same as old password.");
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            return responseMessage;
        }

        if (!registrationDto.getConfirmPassword().equals(registrationDto.getPassword())) {
            responseMessage.setText("New password and confirm password doesn't match.");
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            return responseMessage;
        }

        User user = userRepository.findByUsername(registrationDto.getAgentCode());
        if (!bCryptPasswordEncoder.matches(registrationDto.getOldPassword(), user.getPassword())) {
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setText("Incorrect old password.");
            return responseMessage;
        }

        user.setPassword(bCryptPasswordEncoder.encode(registrationDto.getPassword()));
        user.setChangePassword(Boolean.TRUE);
        userRepository.save(user);
        responseMessage.setText("User password saved successfully.");
        responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
        return responseMessage;
    }
}
