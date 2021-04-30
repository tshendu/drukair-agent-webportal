//package com.ttpl.asd.drukairagentwebportal.auth;
//
//import com.ttpl.asd.drukairagentwebportal.auth.model.User;
//import com.ttpl.asd.drukairagentwebportal.auth.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.Set;
//
//@Component
//public class AuthenticationProviderBean implements AuthenticationProvider {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName();
//        String password = String.valueOf(authentication.getCredentials());
//        User user = (User) userService.findByAgentcode(username);
//        if (user == null) {
//            throw new BadCredentialsException("Login Unauthenticated");
//
//        } else if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
////        } else if (true) {
//            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username,
//                    password, Arrays.asList(new MyGrantedAuthority(user)));
//            token.setDetails(user);
//            return token;
//        } else {
//            throw new BadCredentialsException("ddd");
//        }
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }
//
//    public class MyGrantedAuthority implements GrantedAuthority {
//
//        private static final long serialVersionUID = 5202669007419658413L;
//
//        private User user;
//
//        public MyGrantedAuthority() {
//            super();
//        }
//
//        public MyGrantedAuthority(User user) {
//            this.user = user;
//        }
//
//        @Override
//        public String getAuthority() {
//            return "ROLE_USER";
//        }
//
//    }
//}
