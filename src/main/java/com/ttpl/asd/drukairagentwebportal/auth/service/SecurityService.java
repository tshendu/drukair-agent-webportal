package com.ttpl.asd.drukairagentwebportal.auth.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
