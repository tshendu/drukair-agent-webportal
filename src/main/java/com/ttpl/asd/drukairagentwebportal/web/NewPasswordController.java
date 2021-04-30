package com.ttpl.asd.drukairagentwebportal.web;


import com.ttpl.asd.drukairagentwebportal.auth.model.User;
import com.ttpl.asd.drukairagentwebportal.auth.service.ChangePasswordService;
import com.ttpl.asd.drukairagentwebportal.auth.service.UserService;
import com.ttpl.asd.drukairagentwebportal.dto.UserRegistrationDto;
import com.ttpl.asd.drukairagentwebportal.helper.CurrentUser;
import com.ttpl.asd.drukairagentwebportal.helper.ResponseMessage;
import com.ttpl.asd.drukairagentwebportal.helper.SystemDataInt;
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
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/newPassword")
public class NewPasswordController {
    @Autowired
    private ChangePasswordService changePasswordService;
    @Autowired
    private UserService userService;

    @GetMapping("")
    public String index(HttpServletResponse response,Authentication authentication ) throws IOException {
        String agentCode = authentication.getName();
        User user = userService.findByUsername(agentCode);
        if (user.getChangePassword().equals(Boolean.TRUE)) {
            response.sendRedirect("dashboard");

        }
//        model.addAttribute("registerForm", new User());
        return "newPassword";
    }

    @ResponseBody
    @RequestMapping(value = "/savePassword", method = POST)
    public ResponseMessage save(HttpServletRequest request, HttpServletResponse response, UserRegistrationDto registrationDto,
                                Authentication authentication) throws IOException {
        String agentCode = authentication.getName();
        registrationDto.setAgentCode(agentCode);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage = (ResponseMessage) changePasswordService.savePassword(registrationDto);
//        if (responseMessage.getStatus().equals(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value())) {
//            response.sendRedirect("/webportal/dashboard");
//            request.getSession().invalidate();
//        }

        return responseMessage;

    }


    @RequestMapping(value = "/passwordLogout", method = GET)
    public void logout(HttpServletRequest request, HttpServletResponse response, UserRegistrationDto registrationDto,
                         Authentication authentication) throws IOException {
//        request.getSession().invalidate();
        response.sendRedirect("dashboard");
    }
}
