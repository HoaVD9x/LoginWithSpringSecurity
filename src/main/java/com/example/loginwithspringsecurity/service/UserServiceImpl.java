package com.example.loginwithspringsecurity.service;

import com.example.loginwithspringsecurity.model.User;
import com.example.loginwithspringsecurity.payload.RegisterPayload;
import com.example.loginwithspringsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder encoder;
    @Override
    public void save(RegisterPayload payload) {
        User user = new User(payload.getFirstName(), payload.getLastName(), payload.getEmail(), true);
        userRepository.save(user);
    }


}
//encoder.encode(payload.getPassword()