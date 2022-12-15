//package com.example.loginwithspringsecurity.config;
//
//import com.example.loginwithspringsecurity.model.Attempts;
//import com.example.loginwithspringsecurity.model.User;
//import com.example.loginwithspringsecurity.repository.AttemptsRepository;
//import com.example.loginwithspringsecurity.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//@Component
//public class AuthProvider implements AuthenticationProvider {
//
//    private static final int ATTEMPTS_LIMIT = 5;
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private AttemptsRepository attemptsRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String userName = (authentication.getPrincipal() == null ) ? "NONE_PROVIDER" : authentication.getName();
//        String password = authentication.getCredentials().toString();
//        UserDetails userDetails;
//
//        try {
//            userDetails = userDetailsService.loadUserByUsername(userName);
//            if (!userDetails.isAccountNonLocked()) {
//                throw new BadCredentialsException("Account is locked!");
//            }
//            if (passwordEncoder.matches(password, userDetails.getPassword())) {
//                //reset attempts = 0
//                Optional<Attempts> attempts = attemptsRepository.findByEmail(userName);
//                if (attempts.isPresent()) {
//                    Attempts attempts1 = attempts.get();
//                    attempts1.setAttempts(0);
//                    attemptsRepository.save(attempts1);
//                }
//                return  new UsernamePasswordAuthenticationToken(userName, password, userDetails.getAuthorities());
//            } else {
//                this.calculateAttempts (userName);
//                throw  new BadCredentialsException("Invalid login detail");
//            }
//        }catch (AuthenticationException exception) {
//            throw  new BadCredentialsException("Invalid login details");
//        }
//
//    }
//
//    private void calculateAttempts (String userName) {
//        Optional<User> userOptional = userRepository.findByEmail(userName);
//        if (userOptional.isPresent()) {
//            User user = userOptional.get();
//            if (user.isAccountNonLocked()) {
//                Optional <Attempts> attemptsOptional = attemptsRepository.findByEmail(userName);
//                if (attemptsOptional.isPresent()) {
//                    Attempts attempts = attemptsOptional.get();
//                    if (attempts.getAttempts() + 1 >= ATTEMPTS_LIMIT) {
//                        attempts.setAttempts(attempts.getAttempts() + 1);
//                        attemptsRepository.save(attempts);
//                        user.setAccountNonLocked(false);
//                        userRepository.save(user);
//                    }
//                    attempts.setAttempts(attempts.getAttempts() + 1);
//                    attemptsRepository.save(attempts);
//                } else {
//                    attemptsRepository.save(new Attempts(userName, 1));
//                }
//            }
//        }
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }
//}
