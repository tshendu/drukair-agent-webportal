package com.ttpl.asd.drukairagentwebportal.auth.service;

import com.ttpl.asd.drukairagentwebportal.auth.dao.UserDao;
import com.ttpl.asd.drukairagentwebportal.auth.model.Role;
import com.ttpl.asd.drukairagentwebportal.auth.model.User;
import com.ttpl.asd.drukairagentwebportal.auth.repository.UserRepository;
import com.ttpl.asd.drukairagentwebportal.helper.LoginErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        User user = userDao.getUser(username);
        if (user == null) throw new UsernameNotFoundException(LoginErrorCode.FAILED.getCode());

        else if (user.getStatus().equals(Boolean.FALSE)) throw new LockedException(LoginErrorCode.LOCKED.getCode());

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
