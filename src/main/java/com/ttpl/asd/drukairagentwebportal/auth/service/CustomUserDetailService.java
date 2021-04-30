//package com.ttpl.asd.drukairagentwebportal.auth.service;
//
//import com.ttpl.asd.drukairagentwebportal.auth.model.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Service
//public class CustomUserDetailService implements UserDetailsService {
//
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//
//        if(StringUtils.isEmpty(userName))
//            throw new UsernameNotFoundException("User name is empty");
//
//        //if you don't use authority based security, just add empty set
//        Set<GrantedAuthority> authorities = new HashSet<>();
//        User userDetails = new User(userName, "", authorities);
//
//        //here you can load user's data from DB or from
//        //any other source and do:
//        //userDetails.setFirstName(firstName);
//        //userDetails.setLastName(lastName);
//
//        return userDetails;
//    }
//
//}
