package com.example.loginwithspringsecurity.controller;


import com.example.loginwithspringsecurity.payload.RegisterPayload;
import com.example.loginwithspringsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.LockedException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Controller
public class Home {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(HttpServletRequest request, HttpSession session) {
        return "index";
    }

    @GetMapping("/login")
    public String login (HttpServletRequest request, HttpSession session) {
        return "login";
    }

    @GetMapping("/register")
    public  String register (){
        return "register";
    }

    @PostMapping("/register")
    public String register (@ModelAttribute RegisterPayload registerPayLoad) {
        userService.save(registerPayLoad);
        return "redirect:login";
    }

}
