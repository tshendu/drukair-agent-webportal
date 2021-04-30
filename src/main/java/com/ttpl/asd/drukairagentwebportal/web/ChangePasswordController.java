package com.ttpl.asd.drukairagentwebportal.web;


import com.ttpl.asd.drukairagentwebportal.auth.model.User;
import com.ttpl.asd.drukairagentwebportal.auth.service.ChangePasswordService;
import com.ttpl.asd.drukairagentwebportal.dto.UserRegistrationDto;
import com.ttpl.asd.drukairagentwebportal.helper.CurrentUser;
import com.ttpl.asd.drukairagentwebportal.helper.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/changePassword")
public class ChangePasswordController {
    @Autowired
    private ChangePasswordService changePasswordService;

    @GetMapping("")
    public String index(Model model) {
//        model.addAttribute("registerForm", new User());
        return "changePassword";
    }

    @ResponseBody
    @RequestMapping(value = "/savePassword", method = POST)
    public ResponseMessage save(HttpServletRequest request, UserRegistrationDto registrationDto,
                                Authentication authentication) {
        String agentCode =  authentication.getName();
        registrationDto.setAgentCode(agentCode);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage= (ResponseMessage) changePasswordService.savePassword(registrationDto);
        return responseMessage;

    }
}
