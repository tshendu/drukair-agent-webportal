package com.ttpl.asd.drukairagentwebportal.controller;

import com.ttpl.asd.drukairagentwebportal.auth.service.UserService;
import com.ttpl.asd.drukairagentwebportal.helper.LoginErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(Model model, HttpServletRequest request, String error, String logout) {
        if (error != null) {
//            model.addAttribute("error", "Your username and password is invalid.");
            model.addAttribute("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));

        }
        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }
        return "login";
    }

    @RequestMapping(value = "/logout" )
    public String logout(ModelMap model, HttpServletRequest request){
        request.getSession(true).invalidate();
        System.out.println("logout user page shown--------------------");
        return "login";
    }

    @RequestMapping("")
    public String index(Model model, String error, String logout) {
//        User user = userService.findByAgentcode("111");
//        if (error != null) {
//            model.addAttribute("error", "Your username and password is invalid.");
//        }
//        if (logout != null) {
//            model.addAttribute("message", "You have been logged out successfully.");
//        }
        return "dashboard";
    }

    private String getErrorMessage(HttpServletRequest request, String key) {
        Exception exception = (Exception) request.getSession().getAttribute(key);
        if (exception != null) {
            String message = exception.getMessage();
            if (message.equals(LoginErrorCode.FAILED.getCode())  ||
                    message.equals(LoginErrorCode.LOCKED.getCode())) {
                return message;
            }
            if (message.equals(LoginErrorCode.FAILEDs.getCode())) {
                return "Your username and password is invalid.";
            }
            else {
                return message;
            }
        } else {
            return null;
        }
    }

}
