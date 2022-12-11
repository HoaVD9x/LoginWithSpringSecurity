package com.example.loginwithspringsecurity.service;

import com.example.loginwithspringsecurity.payload.RegisterPayload;

public interface UserService {
    void  save (RegisterPayload payload);
}
