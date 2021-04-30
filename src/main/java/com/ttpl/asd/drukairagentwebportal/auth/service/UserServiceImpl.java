package com.ttpl.asd.drukairagentwebportal.auth.service;

import com.ttpl.asd.drukairagentwebportal.auth.dao.UserDao;
import com.ttpl.asd.drukairagentwebportal.auth.model.User;
import com.ttpl.asd.drukairagentwebportal.auth.repository.RoleRepository;
import com.ttpl.asd.drukairagentwebportal.auth.repository.UserRepository;
import com.ttpl.asd.drukairagentwebportal.dto.UserRegistrationDto;
import com.ttpl.asd.drukairagentwebportal.helper.ResponseMessage;
import com.ttpl.asd.drukairagentwebportal.helper.SystemDataInt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.math.BigInteger;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserDao userDao;

    @Override
    public ResponseMessage editUser(String agentcode) {
        User user = userRepository.findByUsername(agentcode);
        ResponseMessage responseMessage = new ResponseMessage();
//        user.ifPresent(user1 -> {
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        userRegistrationDto.setId(user.getId());
        userRegistrationDto.setUsername(user.getUsername());
        userRegistrationDto.setAgentName(user.getAgentname());
        userRegistrationDto.setAgentCode(user.getAgentcode());
        userRegistrationDto.setStatus(user.getStatus());
//            userRegistrationDto.setAddress(user1.getAddress());
//            userRegistrationDto.setEmail(user1.getUsername());
//            userRegistrationDto.setMobileNumber(user1.getPhoneNumber());
        responseMessage.setDTO(userRegistrationDto);
        responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
//        });
        return responseMessage;
    }

    @Override
    public ResponseMessage save(UserRegistrationDto userRegistrationDto) {
        ResponseMessage responseMessage = new ResponseMessage();
        User userFromDao = userRepository.findByUsername(userRegistrationDto.getUsername());
        if (userFromDao != null) {
            if (userRegistrationDto.getPassword() != null) {
                if (!Objects.equals(userRegistrationDto.getPassword(), "")) {
                    if (userRegistrationDto.getPassword().length() > 0) {
                        userRegistrationDto.setPassword(bCryptPasswordEncoder.encode(userRegistrationDto.getPassword()));
                        userFromDao.setPassword(userRegistrationDto.getPassword());
                    }
                }
            }
            userFromDao.setAgentname(userRegistrationDto.getAgentName());
            userFromDao.setStatus(userRegistrationDto.getStatus());
            userFromDao.setChangePassword(Boolean.FALSE);
            userRepository.save(userFromDao);
            responseMessage.setText("Agent updated successfully for agent name " + userRegistrationDto.getAgentName());
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
        } else {
            if (userRegistrationDto.getPassword() == null) {
                responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
                responseMessage.setText("Password is mandatory.");
                return responseMessage;
            }
            User user = new User();
            user.setAgentname(userRegistrationDto.getAgentName());
            user.setCreatedBy(String.valueOf(new Date()));
            user.setStatus(userRegistrationDto.getStatus());
            user.setUsername(userRegistrationDto.getUsername());
            user.setPassword(bCryptPasswordEncoder.encode(userRegistrationDto.getPassword()));
            user.setRoles(new HashSet<>(roleRepository.findAll()));

            try {
                userRepository.save(user);
                responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
                responseMessage.setText("Data saved successfully");
            } catch (Exception e) {
                responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                responseMessage.setText("Error saving data");

            }
        }
        return responseMessage;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public ResponseMessage getUsers() {
        ResponseMessage responseMessage = new ResponseMessage();

        List<UserRegistrationDto> userList = userDao.getAll();
        responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());

        responseMessage.setDTO(userList);
        return responseMessage;
    }


}
