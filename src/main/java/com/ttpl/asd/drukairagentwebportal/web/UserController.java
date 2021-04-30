package com.ttpl.asd.drukairagentwebportal.web;

import com.ttpl.asd.drukairagentwebportal.auth.model.User;
import com.ttpl.asd.drukairagentwebportal.auth.service.SecurityService;
import com.ttpl.asd.drukairagentwebportal.auth.service.UserService;
import com.ttpl.asd.drukairagentwebportal.auth.validator.UserValidator;
import com.ttpl.asd.drukairagentwebportal.dto.UserRegistrationDto;
import com.ttpl.asd.drukairagentwebportal.helper.CurrentUser;
import com.ttpl.asd.drukairagentwebportal.helper.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.math.BigInteger;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/registration")
public class UserController {

    ResponseMessage responseMessage;
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("")
    public String index(Model model) {
//        model.addAttribute("registerForm", new User());
        return "registration";
    }

    @ResponseBody
    @RequestMapping(value = "/getUser", method = GET)
    public ResponseMessage getUser(HttpServletRequest request, HttpServletResponse response)  throws
            IOException{
//        CurrentUser currentUser = (CurrentUser) request.getSession().getAttribute("emailAddress");
//        ResponseMessage responseMessage;
//        responseMessage = (ResponseMessage) userService.getUsers();
        return userService.getUsers();
    }

    @ResponseBody
    @RequestMapping(value = "/editUser", method = GET)
    public ResponseMessage editUser(HttpServletRequest request, String agentCode) throws
            IOException {
//        CurrentUser currentUser = (CurrentUser) request.getSession().getAttribute("emailAddress");
        ResponseMessage responseMessage;
        responseMessage = (ResponseMessage) userService.editUser(agentCode);
        return responseMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/saveUser", method = POST)
    public ResponseMessage save(HttpServletRequest request, UserRegistrationDto registrationDto) {
        CurrentUser currentUser = (CurrentUser) request.getSession().getAttribute("emailAddress");
        ResponseMessage responseMessage = new ResponseMessage();

//        if (registrationDto.getId() != null) {
//            responseMessage = (ResponseMessage) userService.update(registrationDto);
//        } else {
            responseMessage = (ResponseMessage) userService.save(registrationDto);
//        }
        return responseMessage;

    }
}
