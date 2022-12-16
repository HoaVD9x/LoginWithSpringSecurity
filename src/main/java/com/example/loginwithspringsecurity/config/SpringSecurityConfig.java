package com.example.loginwithspringsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.servlet.ServletException;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    @Autowired
    public AuthProvider authProvider;


    protected static final String [] AUTH_WHITELIST = {"/resources/**", "/js/**", "/images/**",  "/fonts/**", "/less/**", "/css/**" };

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) ->requests.antMatchers("/register/**").permitAll()
                .anyRequest().authenticated())
                .formLogin((form) -> form.loginPage("/login").defaultSuccessUrl("/").usernameParameter("email").passwordParameter("password").permitAll())
                .logout((logout) -> logout.logoutUrl("/logout").logoutSuccessUrl("/login")
                .clearAuthentication(true).invalidateHttpSession(true).addLogoutHandler((((request, response, authentication) ->  {
                    try {
                        request.logout();
                    } catch (ServletException e) {
                        throw  new RuntimeException(e);
                    }
                }))
                        ).permitAll());
        return http.build();
    }

    @Bean
    public AuthenticationManager manager (HttpSecurity http)
            throws Exception  {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(authProvider);
        return authenticationManagerBuilder.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder () {
        return  new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer () {
        return (web) -> web.ignoring().antMatchers(AUTH_WHITELIST);
    }
}
