package com.example.loginwithspringsecurity.service;

import com.example.loginwithspringsecurity.model.User;
import com.example.loginwithspringsecurity.payload.RegisterPayload;
import com.example.loginwithspringsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceImpl implements  UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;
    @Override
    public void save(RegisterPayload payload) {
        User user = new User(payload.getUserName(), payload.getEmail(), encoder.encode(payload.getPassword()), true);
        userRepository.save(user);
    }
}
